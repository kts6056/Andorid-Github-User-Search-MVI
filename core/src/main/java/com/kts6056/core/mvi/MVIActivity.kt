package com.kts6056.core.mvi

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.kts6056.core.base.BaseActivity

abstract class MVIActivity<BINDING : ViewBinding, I : ViewIntent, S : ViewState, E : ViewEffect>(
    inflater: (LayoutInflater) -> BINDING
) : BaseActivity<BINDING>(inflater), MviView<I, S, E> {
    abstract val viewModel: MVIViewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    init {
        lifecycleScope.launchWhenResumed {
            viewModel.state.collect {
                processState(it)
            }
        }
        lifecycleScope.launchWhenResumed {
            viewModel.effect.collect {
                processEffect(it)
            }
        }
    }
}
