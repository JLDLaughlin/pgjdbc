/*
 * Copyright (c) 2003, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package io.materialize.util;

import java.sql.SQLException;

public class PSQLException extends SQLException {

  private ServerErrorMessage serverError;

  public PSQLException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    this.serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return serverError;
  }
}
