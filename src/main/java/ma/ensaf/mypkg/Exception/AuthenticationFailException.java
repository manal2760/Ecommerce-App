package ma.ensaf.mypkg.Exception;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String msg){
        super(msg);
    }
}
