package com.example.mailman

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mailman.databinding.FragmentAccountBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class AccountFragment : Fragment() {

    private lateinit var viewBinding: FragmentAccountBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var gso: GoogleSignInOptions

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAccountBinding.inflate(layoutInflater)

        // Getting the signed-in user
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(activity, gso)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        // Binding user data to the views
        viewBinding.nameTxt.text = currentUser?.displayName
        viewBinding.emailTxt.text = currentUser?.email
        Glide.with(this).load(currentUser?.photoUrl).into(viewBinding.profileImage)

        // Setting up the sign-out button
        viewBinding.signOutBtn.setOnClickListener{
            mAuth.signOut()
            googleSignInClient.signOut()
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        // Inflate the layout for this fragment
        return viewBinding.root
    }


}