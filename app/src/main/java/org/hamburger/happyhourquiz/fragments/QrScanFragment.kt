package org.hamburger.happyhourquiz.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_qr_scan.*

import org.hamburger.happyhourquiz.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QrScanFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class QrScanFragment : Fragment() {
    companion object {
        const val TAG = "QrScanFragment"
    }
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qr_scan, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        qrfragment_scannerview.setResultHandler {
            Log.d(TAG,"result: ${it.barcodeFormat.name}")
            listener?.onScanComplete(it.contents)
            Toast.makeText(context,it.contents,Toast.LENGTH_LONG).show()
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onResume() {
        super.onResume()

        qrfragment_scannerview.startCamera()
    }

    override fun onPause() {
        super.onPause()
        qrfragment_scannerview.stopCamera()
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onScanComplete(data: String)
    }

}
