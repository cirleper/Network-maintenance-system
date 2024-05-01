package com.leaves.pagehelpertest.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 相应信息
 *
 * @author xus
 * @version 1.0
 * @sine 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseMsg<T> {

    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;


    /**
     * 创建成功
     * @return
     */
    @Deprecated
    public static ResponseMsg createSucceess(){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(200);
        return responseMsg;
    }

    /**
     * 创建成功
     * @return
     */
    @Deprecated
    public static ResponseMsg createSuccess(){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(200);
        return responseMsg;
    }

    public static ResponseMsg<Void> success(){
        ResponseMsg<Void> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(200);
        return responseMsg;
    }
    
    /**
     * 创建失败
     * @param code
     * @param msg
     * @return
     */
    @Deprecated
    public static ResponseMsg createError(Integer code, String msg){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(code);
        responseMsg.setMsg(msg);
        return responseMsg;
    }

    public static <T> ResponseMsg<T> error(Integer code, String msg){
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(code);
        responseMsg.setMsg(msg);
        return responseMsg;
    }



    /**
     * 创建成功
     * @param data
     * @return
     */
    public static ResponseMsg createSuccess(Object data){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(200);
        responseMsg.setData(data);
        return responseMsg;
    }

    public static <T> ResponseMsg<T> success(T data){
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(200);
        responseMsg.setData(data);
        return responseMsg;
    }


}
