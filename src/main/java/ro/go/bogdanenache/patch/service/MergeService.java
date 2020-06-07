package ro.go.bogdanenache.patch.service;

import org.apache.commons.beanutils.*;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.copyProperty;


@Service
public class MergeService<T> {


    public <T> T merge(T local, T remote) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = local.getClass();
        Object merged = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object localValue = field.get(local);
            Object remoteValue = field.get(remote);
            if (localValue != null) {
                switch (localValue.getClass().getSimpleName()) {
                    case "ArrayList":
                        System.out.println("test");
                        break;
                    case "AddressDTO":
                        field.set(merged, this.merge(localValue, remoteValue));
                        break;
                    default:
                        field.set(merged, (remoteValue != null) ? remoteValue : localValue);
                }
            }
        }
        return (T) merged;
    }
    public <T> T mergeWithBEanUtil(T local, T remote) throws IllegalAccessException, InstantiationException {
        try {
            copyProperties(local, remote);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return local;
    }

    public void copyProperties(final Object dest, final Object orig)
            throws IllegalAccessException, InvocationTargetException {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            final PropertyDescriptor[] origDescriptors =
                    propertyUtilsBean.getPropertyDescriptors(orig);
            for (PropertyDescriptor origDescriptor : origDescriptors) {
                final String name = origDescriptor.getName();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                if (propertyUtilsBean.isReadable(orig, name) &&
                        propertyUtilsBean.isWriteable(dest, name)) {
                    try {
                        final Object value =
                                propertyUtilsBean.getSimpleProperty(orig, name);
                        copyProperty(dest, name, value);
                    } catch (final NoSuchMethodException e) {
                        // Should not happen
                    }
                }
            }

    }
}
