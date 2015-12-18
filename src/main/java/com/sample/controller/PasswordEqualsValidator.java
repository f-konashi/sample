package com.sample.controller;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sample.form.PasswordResetForm;
/**
 * Spring Validator実装クラスは、使用するControllerと同じパッケージに配置することを推奨する。
 * 
 * @author f-konashi
 *
 */
@Component
public class PasswordEqualsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PasswordResetForm.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        PasswordResetForm form = (PasswordResetForm) target;
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        
        // フィールドがnullかどうかのチェックは、@NotNullアノテーションに任せる。
        // (このValidatorでは、フィールドがnullの場合は正常値とみなす)
        if (password == null || confirmPassword == null) {
            return;
        }
        // チェックロジックを実装する。
        if (!password.equals(confirmPassword)) {
            //引数1:エラー対象のフィールド名を指定する。
            //引数2:エラーメッセージのコード名を指定する。
            //引数3:エラーメッセージをコードで解決できなかった場合に使用するデフォルトメッセージ
            errors.rejectValue("password",
                    "PasswordEqualsValidator.passwordResetForm.password",
                    "password and confirm password must be same.");
        }
    }
}
