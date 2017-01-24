package hk.edu.polyu.comp3222.vfs.core;

/**
 * Created by Isaac on 1/24/17.
 *
 */
interface ResponseHandler {
    void handlerResponse(String xxp);
}

class ListResponseHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}

class DirectResponseHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}

class CreateHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}

class MoveResponseHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}

class RenameResponseHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}

class SearchResponseHandler implements ResponseHandler{
    public void handlerResponse(String xxp){}
}


