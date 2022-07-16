package com.coroutinesexample.models

import com.google.gson.annotations.SerializedName


data class Settings (

  @SerializedName("woocommerce_enable_myaccount_registration"  ) var woocommerceEnableMyaccountRegistration  : String? = null,
  @SerializedName("woocommerce_registration_generate_username" ) var woocommerceRegistrationGenerateUsername : String? = null,
  @SerializedName("woocommerce_registration_generate_password" ) var woocommerceRegistrationGeneratePassword : String? = null,
  @SerializedName("woocommerce_enable_guest_checkout"          ) var woocommerceEnableGuestCheckout          : String? = null

)