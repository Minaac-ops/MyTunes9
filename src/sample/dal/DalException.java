package sample.dal;

public class DalException extends Exception {


    public DalException()
    {
        super();
    }

    public DalException(String message)
    {
        super(message);
    }

    public DalException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DalException(String message, Exception ex)
    {
        super(message, ex);
    }
}
