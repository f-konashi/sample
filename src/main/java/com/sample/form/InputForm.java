package com.sample.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sample.message.Message;
import com.sample.validator.HasAtsign;
import com.sample.validator.HasDot;

/**
 * 入力フォームで使いそうなフィールドとアクセスメソッドを分割して記述してます.
 * 必要なところだけ、コピペして利用して下さい.
 * 
 * @author Fumihiro Konashi
 * @since 2015/12/15
 */
public class InputForm {
	// *******************************************************
	// 名前
	// *******************************************************
	
	/**
	 * 入力フォームの「名前」テキストボックスに対応するフィールド. 1文字以上50文字以内で入力されているかバリデーションする.
	 */
	@NotEmpty(message = Message.ERROR_EMPTY)
	@Length(max = 50, message = Message.ERROR_MAX_LENGTH)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
	// *******************************************************
	// メールアドレス
	// *******************************************************
	
	/**
	 * 入力フォームの「メールアドレス」テキストボックスに対応するフィールド.
	 * <p>{@literal @HasAtsign}:入力値に「@(アットマーク)」が含まれるかバリデーションします.</p>
	 * <p>{@literal @HasDot}:入力値に「.(ドット)」が含まれるかバリデーションします.</p>
	 * <p>{@literal @Email}:入力値がEmail形式であるか確認します.</p>
	 */
  @HasAtsign
  @HasDot
  @Email
  public String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	
	// *******************************************************
	// メールアドレス
	// *******************************************************
	
	@Pattern(regexp = "\\d{3}", message = "3桁の数字を入力して下さい。")
	@NotEmpty(message = Message.ERROR_EMPTY)
	private String postalCode1;

	@Pattern(regexp = "\\d{4}", message = "4桁の数字を入力して下さい。")
	@NotEmpty(message = Message.ERROR_EMPTY)
	private String postalCode2;

	@NotEmpty(message = Message.ERROR_EMPTY)
	private String address;

	@NotEmpty(message = Message.ERROR_SELECT)
	private String payment;

	@NotEmpty(message = Message.ERROR_SELECT)
	private String delivery;



	/**
	 * 入力フォームの「性別」ラジオボタンに対応するフィールド. 選択されているかどうかバリデーションする.
	 */
	@NotEmpty(message = Message.ERROR_SELECT)
	private String gender;

	/**
	 * 入力フォームの「ログインID」テキストボックスに対応するフィールド. 5文字以上50文字以内で入力されているかバリデーションする.
	 */
	@NotEmpty(message = Message.ERROR_EMPTY)
	@Length(min = 5, max = 50, message = Message.ERROR_MINMAX_LENGTH)
	private String loginId;

	/**
	 * 入力フォームの「ログインID」テキストボックスに対応するフィールド. 5文字以上50文字以内で入力されているかバリデーションする.
	 */
	@NotEmpty(message = Message.ERROR_EMPTY)
	@Length(min = 5, max = 50, message = Message.ERROR_MINMAX_LENGTH)
	private String password;

	// *******************************************************
	// アクセッサーメソッド
	// *******************************************************

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId == null ? null : loginId.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getPostalCode1() {
		return postalCode1;
	}

	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	public String getPostalCode2() {
		return postalCode2;
	}

	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment == null ? null : payment.trim();
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery == null ? null : delivery.trim();
	}
}
