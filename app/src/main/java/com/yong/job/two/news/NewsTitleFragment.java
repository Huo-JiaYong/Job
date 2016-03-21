package com.yong.job.two.news;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yong.job.R;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View view;
    private ListView lv_title;
    private NewsAdapter adapter;
    private List<News> list;
    private boolean isLand;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //初始化新闻数据
        list = getNews();
        adapter = new NewsAdapter(getActivity(), R.layout.news_title_item, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_title_fragment, container, false);
        lv_title = (ListView) view.findViewById(R.id.lv_title);
        lv_title.setAdapter(adapter);

        lv_title.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //判断是否加载为平板
        if (view.findViewById(R.id.content_fragment_layout) != null) {
            isLand = true;
        } else {
            isLand = false;
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News item = (News) list.get(position);
        //根据是否平板选择加载方式
        if (isLand) {
            NewsContentFragment contentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id
                    .content_fragment);

            contentFragment.refresh(item.getTitle(), item.getContent());
        } else {
            NewsContentActivity.actionStart(getActivity(), item.getTitle(), item.getContent());
        }
    }

    public List getNews() {
        List<News> news = new ArrayList<News>();
        News item = new News();
        item.setTitle("习近平听取北京冬奥会冬残奥会筹办工作情况汇报");
        item.setContent("中共中央总书记、国家主席、中央军委主席习近平18" +
                "日在中南海主持召开会议，专题听取北京冬奥会、冬残奥会筹办工作情况汇报。他强调，筹办好北京冬奥会、冬残奥会，意义重大，责任重大。要增强使命感、责任感，认真落实创新、协调、绿色、开放、共享的发展理念，坚持绿色办奥、共享办奥、开放办奥、廉洁办奥，高标准、高质量完成各项筹办任务，把北京冬奥会、冬残奥会办成一届精彩、非凡、卓越的奥运盛会，向祖国人民、向国际社会交上一份满意答卷。");
        news.add(item);
        News item1 = new News();
        item1.setTitle("李克强将出席博鳌亚洲论坛2016年年会");
        item1.setContent
                ("出席澜沧江—湄公河合作首次领导人会议的湄公河五国领导人、尼泊尔总理奥利、立陶宛总理布特克维丘斯、比利时首相米歇尔、印度尼西亚副总统卡拉、韩国副总理兼企划财政部长官柳一镐、俄罗斯副总理德沃尔科维奇等外国政要将应邀出席年会。");
        news.add(item1);
        News item2 = new News();
        item2.setTitle("川辽冲突罚单：四川罚款15万 辽宁冲突球员依法处理");
        item2.setContent("新浪体育讯 " +
                "北京时间3月18日消息，据前方记者透露，辽宁队昨天并没有进行训练，而今天上午按照惯例的赛前训练，辽宁队也没有出现在球馆。在上午例行的联席会上，辽宁队的相关人员也没有出现。\n" +
                "此前曾有媒体曝出，在辽宁球员和四川球迷的冲突过后，辽宁队的高层和中国篮协竞赛部负责人张雄还有四川当地警方一起开始讨论事情的善后，警方曾提出要将辽宁队的队员进行拘留处理，这遭到了辽宁队总经理严晓明的强烈反对，随后竞赛部负责人张雄提出要将辽宁队的多名主力禁赛，这也同样遭到了辽宁队总经理严晓明的反对。");
        news.add(item2);
        News item3 = new News();
        item3.setTitle("乐视体育是否值205亿？");
        item3.setContent("3月15日晚间，凯撒旅游的一纸对外投资公告，揭开乐视体育B轮融资的神秘面纱。综合信息显示，乐视体育B轮融资规模共70亿元，融资完成后，乐视体育估值达205" +
                "亿元。而此时乐视体育独立才两年，2015年营收仅为4.17亿元，205亿估值是否虚高？");
        news.add(item3);
        News item4 = new News();
        item4.setTitle("“冰晨”房产信息曝光 房管局：违纪人员被辞退");
        item4.setContent("中新网3月18日电 " +

 "据山东省青岛市国土资源局和房屋管理局官方微博消息，针对日前有网友投诉青岛房管局泄露范冰冰李晨青岛购豪宅信息，青岛市国土资源局和房屋管理局今日通过官方微博回应称，青岛市不动产登记中心一名工作人员违反工作纪律，擅自查询当事人购房信息并发送到个人微信亲友群，现已被辞退。");
        news.add(item4);
        return news;
    }
}
