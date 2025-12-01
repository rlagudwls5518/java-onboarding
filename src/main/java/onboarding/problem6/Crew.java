package onboarding.problem6;

public class Crew {

    private final String nickName;
    private final String email;


    public Crew(String nickName, String email) {
        CrewEmailValidator();
        this.nickName = nickName;
        this.email = email;
    }

    public String getNickname() {
        return nickName;
    }
    public String getEmail() {
        return email;
    }

    private void CrewEmailValidator(){

    }
}
