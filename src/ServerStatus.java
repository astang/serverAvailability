/**
 * Created by alice on 04.02.2019.
 */
public enum ServerStatus {
    UNCLEARERROR, //Default
    SUCCESSFUL, //1xx Information (to need more time, can be cut caused by time out) && 2xx SUCCESSFUL
    REDIRECT, //3xx
    CLIENTERROR, //4xx
    SERVERERROR //5xx
}
