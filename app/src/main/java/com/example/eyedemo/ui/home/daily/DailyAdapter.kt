package com.example.eyedemo.ui.home.daily

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eyedemo.BuildConfig
import com.example.eyedemo.Const
import com.example.eyedemo.R
import com.example.eyedemo.extension.*
import com.example.eyedemo.logic.model.Daily
import com.example.eyedemo.ui.LoginActivity
import com.example.eyedemo.ui.common.holder.*
import com.example.eyedemo.util.ActionUrlUtil
import com.example.eyedemo.util.GlobalUtil
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class DailyAdapter(val fragment: DailyFragment, val dataList: List<Daily.Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "DailyAdapter"
        const val DEFAULT_LIBRARY_TYPE = "DEFAULT"
        const val NONE_LIBRARY_TYPE = "NONE"
        const val DAILY_LIBRARY_TYPE = "DAILY"
    }

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        RecyclerViewHelp.getViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        when (holder) {
            is TextCardViewHeader5ViewHolder -> {
                holder.tvTitle5.text = item.data.text
                if (item.data.actionUrl != null) holder.ivInto5.visible() else holder.ivInto5.gone()
                if (item.data.follow != null) holder.tvFollow.visible() else holder.tvFollow.gone()
                holder.tvFollow.setOnClickListener { LoginActivity.start(fragment.activity) }
                setOnClickListener(holder.tvTitle5, holder.ivInto5) {
                    ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                }
            }
            is TextCardViewHeader7ViewHolder -> {
                holder.tvTitle7.text = item.data.text
                holder.tvRightText7.text = item.data.rightText
                setOnClickListener(holder.tvRightText7, holder.ivInto7) {
                    ActionUrlUtil.process(
                        fragment,
                        item.data.actionUrl,
                        "${item.data.text},${item.data.rightText}"
                    )
                }
            }
            is TextCardViewHeader8ViewHolder -> {
                holder.tvTitle8.text = item.data.text
                holder.tvRightText8.text = item.data.rightText
                setOnClickListener(holder.tvRightText8, holder.ivInto8) {
                    ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                }
            }
            is TextCardViewFooter2ViewHolder -> {
                holder.tvFooterRightText2.text = item.data.text
                setOnClickListener(holder.tvFooterRightText2, holder.ivTooterInto2) {
                    ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                }
            }
            is TextCardViewFooter3ViewHolder -> {
                holder.tvFooterRightText3.text = item.data.text
                setOnClickListener(
                    holder.tvRefresh,
                    holder.tvFooterRightText3,
                    holder.ivTooterInto3
                ) {
                    if (this == holder.tvRefresh) {
                        "${holder.tvRefresh.text},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
                    } else if (this == holder.tvFooterRightText3 || this == holder.ivTooterInto3) {
                        ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                    }
                }
            }
            is Banner3ViewHolder -> {
                holder.ivPicture.load(item.data.image, 4f)
                holder.ivAvatar.load(item.data.header.icon)
                holder.tvTitle.text = item.data.header.title
                holder.tvDescription.text = item.data.header.description
                if (item.data.label?.text.isNullOrEmpty()) holder.tvLabel.invisible() else holder.tvLabel.visible()
                holder.tvLabel.text = item.data.label?.text ?: ""
                holder.itemView.setOnClickListener {
                    ActionUrlUtil.process(
                        fragment,
                        item.data.actionUrl,
                        item.data.header.title
                    )
                }
            }
            is FollowCardViewHolder -> {
                holder.ivVideo.load(item.data.content.data.cover.feed, 4f)
                holder.ivAvatar.load(item.data.header.icon)
                holder.tvVideoDuration.text =
                    item.data.content.data.duration.conversionVideoDuration()
                holder.tvDescription.text = item.data.header.description
                holder.tvTitle.text = item.data.header.title
                if (item.data.content.data.ad) holder.tvLabel.visible() else holder.tvLabel.gone()
                if (item.data.content.data.library == DAILY_LIBRARY_TYPE) holder.ivChoiceness.visible() else holder.ivChoiceness.gone()
                holder.ivShare.setOnClickListener {
                    showDialogShare(
                        fragment.activity,
                        "${item.data.content.data.title}：${item.data.content.data.webUrl.raw}"
                    )
                }
                holder.itemView.setOnClickListener {
                    item.data.content.data.run {
                        if (ad || author == null) {
                            NewDetailActivity.start(fragment.activity, id)
                        } else {
                            NewDetailActivity.start(
                                fragment.activity,
                                NewDetailActivity.VideoInfo(
                                    id,
                                    playUrl,
                                    title,
                                    description,
                                    category,
                                    library,
                                    consumption,
                                    cover,
                                    author,
                                    webUrl
                                )
                            )
                        }
                    }
                }
            }
            is InformationCardFollowCardViewHolder -> {
                holder.ivCover.load(
                    item.data.backgroundImage,
                    4f,
                    RoundedCornersTransformation.CornerType.TOP
                )
                holder.recyclerView.setHasFixedSize(true)
                if (holder.recyclerView.itemDecorationCount == 0) {
                    holder.recyclerView.addItemDecoration(CommendAdapter.InformationCardFollowCardItemDecoration())
                }
                holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
                holder.recyclerView.adapter = CommendAdapter.InformationCardFollowCardAdapter(
                    fragment.activity,
                    item.data.actionUrl,
                    item.data.titleList
                )
                holder.itemView.setOnClickListener {
                    ActionUrlUtil.process(
                        fragment,
                        item.data.actionUrl
                    )
                }
            }
            else -> {
                holder.itemView.gone()
                if (BuildConfig.DEBUG) "${TAG}:${Const.Toast.BIND_VIEWHOLDER_TYPE_WARN}\n${holder}".showToast()
            }
        }
    }
}