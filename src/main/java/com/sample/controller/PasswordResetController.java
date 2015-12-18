package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.form.PasswordResetForm;

@Controller
public class PasswordResetController {
    //  使用するSpring Validatorを、インジェクションする。
    //@Inject
    @Autowired
    PasswordEqualsValidator passwordEqualsValidator;
    
    /**
     * 画面で使うフォームに対応したオブジェクトを初期化し、Modelに追加します(Thymeleafからアクセスさせるために必要).
     *
     * @param なし
     * @return フォームへの入力値を格納するオブジェクト
     */
    @ModelAttribute
    public PasswordResetForm setupPasswordResetForm() {
        return new PasswordResetForm();
    }

    // @InitBinderアノテーションがついたメソッド内で、WebDataBinder.addValidatorメソッドにより、
    // Validatorを追加する。これにより、@Validatedアノテーションでバリデーションをする際に、
    // 追加したValidatorも呼び出される。
    
    /**
     * {@literal @InitBinder}アノテーションがついたメソッド内で、WebDataBinder.addValidatorメソッドにより、
     * Validatorを追加する。
     * これにより、@Validatedアノテーションでバリデーションをする際に、追加したValidatorも呼び出される。
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordEqualsValidator);
    }

    /**
     * 初期表示
     * 
     * @return
     */
    @RequestMapping(value = "inputPassword", method = RequestMethod.GET)
    public String resetForm() {
        return "inputPassword";
    }

    /**
     * 「送信」ボタンがクリックされたとき
     * 
     * @param form
     * @param result
     * @return
     */
    @RequestMapping(value = "inputPassword", method = RequestMethod.POST)
    public String reset(@Validated PasswordResetForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "inputPassword";
        }
        return "redirect:/inputPassword?complete";
    }

    /**
     * バリデーションチェックOKのとき
     * 
     * @return
     */
    @RequestMapping(value = "inputPassword", method = RequestMethod.GET, params = "complete")
    public String resetComplete() {
        return "inputPassword";
    }
}
