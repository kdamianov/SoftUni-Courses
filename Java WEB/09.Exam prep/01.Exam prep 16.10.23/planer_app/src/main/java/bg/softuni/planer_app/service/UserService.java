package bg.softuni.planer_app.service;

import bg.softuni.planer_app.model.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

}
