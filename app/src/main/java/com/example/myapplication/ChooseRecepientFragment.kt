package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseRecepientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseRecepientFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController
    private var recipientName_edittext: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChooseRecepientFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChooseRecepientFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_button).setOnClickListener(this)
        recipientName_edittext = view.findViewById(R.id.recipientName_edittext)
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.next_button -> {
                if (!TextUtils.isEmpty(recipientName_edittext?.text.toString())) {
//                    val bundle = bundleOf("recipientName" to recipientName_edittext?.text.toString())
//                    navController.navigate(R.id.action_chooseRecepientFragment_to_specifyAmountFragment)
                    findNavController().navigate(
                        ChooseRecepientFragmentDirections.actionChooseRecepientFragmentToSpecifyAmountFragment(
                            recipientName_edittext?.text.toString()
                        )
                    )
                }
            }

            R.id.cancel_button -> requireActivity().onBackPressed()
        }

    }
}