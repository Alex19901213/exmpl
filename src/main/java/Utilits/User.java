package Utilits;

public class User {
    private String sysPath = "src/config/UsersConfig";
    private YamlReader yamlReader = new YamlReader();

    public  String customerEmail = yamlReader.sysGetObj(sysPath, "Customer", "email");
    public  String customerPasswrd = yamlReader.sysGetObj(sysPath, "Customer", "password");

}
