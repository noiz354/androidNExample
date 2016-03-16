package com.example.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by noiz354 on 3/16/16.
 */
public class ForgotPasswordData {
    @SerializedName("config")
    @Expose
    String config;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("server_process_time")
    @Expose
    String serverProcessTime;
    @SerializedName("data")
    @Expose
    ForgotPasswordModel forgotPasswordModel;
    @SerializedName("message_error")
    @Expose
    List<String> messageError;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServerProcessTime() {
        return serverProcessTime;
    }

    public void setServerProcessTime(String serverProcessTime) {
        this.serverProcessTime = serverProcessTime;
    }

    public ForgotPasswordModel getForgotPasswordModel() {
        return forgotPasswordModel;
    }

    public void setForgotPasswordModel(ForgotPasswordModel forgotPasswordModel) {
        this.forgotPasswordModel = forgotPasswordModel;
    }

    public List<String> getMessageError() {
        return messageError;
    }

    public void setMessageError(List<String> messageError) {
        this.messageError = messageError;
    }

    @Override
    public String toString() {
        return "ForgotPasswordData{" +
                "config='" + config + '\'' +
                ", status='" + status + '\'' +
                ", serverProcessTime='" + serverProcessTime + '\'' +
                ", forgotPasswordModel=" + forgotPasswordModel +
                ", messageError=" + messageError +
                '}';
    }

    public static class ForgotPasswordModel {

        @SerializedName("url_redirect")
        @Expose
        String urlRedirect;
        @SerializedName("is_success")
        @Expose
        int isSuccess;

        public String getUrlRedirect() {
            return urlRedirect;
        }

        public void setUrlRedirect(String urlRedirect) {
            this.urlRedirect = urlRedirect;
        }

        public int getIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(int isSuccess) {
            this.isSuccess = isSuccess;
        }

        @Override
        public String toString() {
            return "ForgotPasswordModel{" +
                    "urlRedirect='" + urlRedirect + '\'' +
                    ", isSuccess=" + isSuccess +
                    '}';
        }
    }
}
