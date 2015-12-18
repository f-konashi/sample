package com.sample.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * バリデーション(相関項目チェック)
 * 
 * @author f-konashi
 *
 */
public class PasswordResetForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * パスワード
     * (入力必須・8文字以上・confirmPasswordと同じ値であること)
     * ※パスワードは、通常ハッシュ化してデータベースに保存する為、最大値のチェックは行わなくても良い。
     * 
     */
    @NotNull
    @Size(min = 8)
    private String password;
    
    /**
     * パスワード(確認用)
     * 
     */
    private String confirmPassword;

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword セットする confirmPassword
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
 
}
