package com.applifting.spacex.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.applifting.spacex.common.connection.NetworkConnectionLiveData
import javax.inject.Inject

/**
 * Base fragment to standardize and simplify initialization for this component.
 *
 * @param layoutId Layout resource reference identifier.
 * @see Fragment
 */

const val INITIAL_ARGS = "initialArgs"

abstract class BaseFragment<B : ViewDataBinding, M : BaseViewModel>(
  @LayoutRes
  private val layoutId: Int
) : Fragment() {

  @Inject
  lateinit var viewModel: M
  private var _binding: B? = null
  val viewBinding get() = _binding!!

  private lateinit var networkConnectionLiveData: NetworkConnectionLiveData

  /**
   * Called to initialize dagger injection dependency graph when fragment is attached.
   */
  abstract fun onInitDependencyInjection()

  /**
   * Called to have the fragment instantiate its user interface view.
   *
   * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
   * @param container If non-null, this is the parent view that the fragment's UI should be
   * attached to. The fragment should not add the view itself, but this can be used to generate
   * the LayoutParams of the view.
   * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous
   * saved state as given here.
   *
   * @return Return the View for the fragment's UI, or null.
   *
   * @see Fragment.onCreateView
   */
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    networkConnectionLiveData = NetworkConnectionLiveData(requireCompatActivity())
    _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    viewBinding.lifecycleOwner = viewLifecycleOwner
    viewModel.onNetworkConnection(networkConnectionLiveData)

    return viewBinding.root
  }

  /**
   * Called when a fragment is first attached to its context.
   *
   * @param context The application context.
   *
   * @see Fragment.onAttach
   */
  override fun onAttach(context: Context) {
    super.onAttach(context)
    onInitDependencyInjection()
  }

  /**
   * Return the [AppCompatActivity] this fragment is currently associated with.
   *
   * @throws IllegalStateException if not currently associated with an activity or if associated
   * only with a context.
   * @throws TypeCastException if the currently associated activity don't extend [AppCompatActivity].
   *
   * @see requireActivity
   */
  fun requireCompatActivity(): AppCompatActivity {
    requireActivity()
    val activity = requireActivity()
    if (activity is AppCompatActivity) {
      return activity
    } else {
      throw TypeCastException("Main activity should extend from 'AppCompatActivity'")
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.onCreate(arguments)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
