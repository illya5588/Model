package exceptions;

import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

import java.sql.SQLException;

public class UniqueException extends SQLException {
    public UniqueException(String message) {

        super(message);


    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

