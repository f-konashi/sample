package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.form.InputForm;

import javax.validation.Valid;

/**
 * アプリケーション全体を制御するクラスです(controller).
 * 
 * @author f-konashi
 */
@Controller
public class InputController {

	/**
	 * 画面で使うフォームに対応したオブジェクトを初期化し、Modelに追加します(Thymeleafからアクセスさせるために必要).
	 *
	 * @param なし
	 * @return フォームへの入力値を格納するオブジェクト
	 */
	@ModelAttribute
	InputForm setupOrderInfoForm() {
		return new InputForm();
	}

	/**
	 * ルートページにアクセスされた場合、inputページにリダイレクトします.
	 * 
	 * @param model
	 * @return ブラウザに表示するページ
	 */
	@RequestMapping(value = { "/" })
	public String redirectInput(Model model) {
		return "redirect:input";
	}

	/**
	 * inputページをブラウザに表示します.
	 * 
	 * @param model
	 * @return ブラウザに表示するページ
	 */
	@RequestMapping(value = { "/input" })
	public String displayInput(Model model) {
		return "input";
	}

	/**
	 * フォーム入力値をバリデーションします.
	 * 
	 * @param model modelです
	 * @param inputForm 
	 * @param result resultです
	 * 
	 * @return ブラウザに表示するページ
	 */
	@RequestMapping("/submit")
	public String input(Model model, @Valid InputForm inputForm, BindingResult result) {
		String page = "input";
		// フォーム入力値をチェックする.
		if (result.hasErrors()) {
			page = "input";
		}
		return page;
	}
}