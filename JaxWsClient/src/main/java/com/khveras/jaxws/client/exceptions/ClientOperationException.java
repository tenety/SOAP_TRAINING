package com.khveras.jaxws.client.exceptions;

public class ClientOperationException extends RuntimeException
{
  private static final long serialVersionUID = 4150430542627979642L;

  public ClientOperationException( String errorMessage )
  {
    super( errorMessage );
  }

  public ClientOperationException( String message, Throwable cause )
  {
    super( message, cause );
  }
}
