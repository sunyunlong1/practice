package com.example.data;

import lombok.Builder;
import lombok.Data;

/**
 * Description:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:52
 */
@Data
public class ApiResponse<T> {

  public String code;

  public String msg;

  public T data;

  public String isSuccess;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getIsSuccess() {
    return isSuccess;
  }

  public void setIsSuccess(String isSuccess) {
    this.isSuccess = isSuccess;
  }


}
