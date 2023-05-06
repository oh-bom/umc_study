package com.ohbom.challenge02_viewpager2//package com.ohbom.challenge02_viewpager2
//
//import android.graphics.drawable.Drawable
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.core.content.ContextCompat
//import com.ohbom.challenge02_viewpager2.databinding.FragmentSecondBinding
//
//class secondFragment(title: String, imageUrl: Int) : Fragment() {
//    private lateinit var binding:FragmentSecondBinding
//    private var title:String?=null
//    private var imageUrl:Int=0
//
//    companion object {
//        fun newInstance(title: String, imageUrl: Int):secondFragment{
//            return secondFragment(title,imageUrl)
//        }
//
//        private const val ARG_TITLE = "arg_title"
//        private const val ARG_IMAGE_URL = "arg_image_url"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentSecondBinding.inflate(layoutInflater)
//        binding.title.text=title
////        binding.imageView.setImageResource(imageUrl)
//
//        return binding.root
//    }
//
////    fun setImageDrawable(drawable: Drawable){
////        binding.imageView.setImageDrawable(drawable)
////    }
//
//}