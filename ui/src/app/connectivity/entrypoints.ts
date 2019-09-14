import {environment} from "../../environments/environment";

export class Entrypoints {

  private static MEDIA_URL = `http://${environment.hostName}:${environment.hostPort}/${environment.apiPrefix}`;

  public static SIGN_IN = `${Entrypoints.MEDIA_URL}/signin`;
  public static SIGN_UP = `${Entrypoints.MEDIA_URL}/signup`;
}
