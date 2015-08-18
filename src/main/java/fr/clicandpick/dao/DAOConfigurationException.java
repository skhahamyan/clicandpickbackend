package fr.clicandpick.dao;

/**
 * Created by Marc on 13/08/2015.
 */
public class DAOConfigurationException extends RuntimeException {
    public DAOConfigurationException( String message ) {
        super( message );
    }

    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
}