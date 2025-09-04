package myproject.objs;

import io.cucumber.core.runtime.SingletonObjectFactorySupplier;


public class RegisterDataSingleton {
    private static RegisterData instance;


    private RegisterDataSingleton(){
        if(instance == null){
            this.instance=new RegisterData();
        }
    }

    public RegisterData getInstance(){
        return instance;
    }

}
