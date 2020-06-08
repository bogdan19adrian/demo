package ro.go.bogdanenache.patch.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.go.bogdanenache.patch.api.UserDTO;
import ro.go.bogdanenache.patch.api.update.PatchUserDTO;
import ro.go.bogdanenache.patch.dao.TestDAO;

@Service
@Slf4j
@AllArgsConstructor
public class TestService {

    private final TestDAO testDAO;
    private final ModelMapper modelMapper;
    private final MergeService<UserDTO> mergeService;

    public void createUser() {
    }

    public UserDTO getUser() {
        return modelMapper.map(testDAO.getUser(), UserDTO.class);
    }

    public UserDTO  updateUserPartial(PatchUserDTO remoteUserDTO) throws InstantiationException, IllegalAccessException {
        UserDTO localUserDTO = modelMapper.map(testDAO.getUser(), UserDTO.class);
        return mergeService.mergeUsingBeanUtils(localUserDTO, remoteUserDTO);
    }

    public UserDTO updateUserFull(UserDTO remoteUserDTO) {
       UserDTO localUserDTO = modelMapper.map(testDAO.getUser(), UserDTO.class);
        UserDTO updatedUser = null;
        try {
           updatedUser  = mergeService.merge(localUserDTO, remoteUserDTO);
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("Smth went wrong ", e);
        }
        log.info("Merged object {}", updatedUser);
        return updatedUser;
    }
}
