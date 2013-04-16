package com.khveras.jaxws.validators;

/**
 * @author Andrei Khveras
 */
public class InvalidDestinationException extends RuntimeException
{
  private static final long serialVersionUID = 4150430542627979642L;

  public InvalidDestinationException( String errorMessage )
  {
    super( errorMessage );
  }

  public InvalidDestinationException( String message, Throwable cause )
  {
    super( message, cause );
  }
}
