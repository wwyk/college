package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.example.hp.college.Activity.fragment.Fragment.FaxianPageFragment;
import com.example.hp.college.Activity.fragment.Fragment.JiaowuPageFragment;
import com.example.hp.college.Activity.fragment.Fragment.ShezhiPageFragment;
import com.example.hp.college.Activity.fragment.Fragment.ShouyePageFragment;
import com.example.hp.college.R;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.util.DaoManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity" ;
    ScrollView scrollView;
    ShouyePageFragment shouyePageFragment;
    JiaowuPageFragment jiaowuPageFragment;
    FaxianPageFragment faxianPageFragment;
    ShezhiPageFragment shezhiPageFragment;
    FragmentManager fragmentManager;
    String [] fragmentsNames = {"shouyePageFragment","jiaowuPageFragment","faxianPageFragment","shezhiPageFragment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(MainActivity.this);
        DaoSession daoSession = daoManager.getDaoSession();
        //tzgg添加
//        TzggContactDao tzggContactDao = daoSession.getTzggContactDao();
//        TzggContact tzggContact = new TzggContact();
//        tzggContact.setTitle("关于上海海洋大学第一届环境生态科技创新大赛活动通知");
//        tzggContact.setData(" 随着我国社会经济的不断发展，环境污染、生态退化、资源枯竭等生态环境问题日益凸显。伴随着人类社会的不断进步，人们对生活质量的要求不断提升，自党的十九大报告中指出，加快生态文明体制改革,建设美丽中国，将保护和建设美好生态环境而取得的物质成果、精神成果和制度成果，贯穿于经济建设、政治建设、文化建设和社会建设的全过程。\n" +
//                "\n" +
//                "随着我国生态文明建设进程的不断加进，国家对环境生态专业人才和环境生态科技创新产品的需求不断增加。为此，本届大赛以“生态意识、生态科技、生态创新，助推生态文明”为主题。立足生态环境保护友好产品的创新设计，推动高校大学生的自主创业，进一步加进生态文明建设的步伐。于此同时，大赛将广泛地关注大学生环境生态基本常识和专业基础知识的掌握和灵活运用能力。\n" +
//                "\n" +
//                "一、大赛目的\n" +
//                "\n" +
//                "上海海洋大学环境生态科技创新大赛的目的是依托自然保护与环境生态知识，倡导生态文明理念，并以科技竞赛的形式，检阅大学生的科研实践能力，培养大学生的创新能力，展示发明创造成果；引导大学生夯实生态环境保护的基础、勇于创新、关注热点生态与环境问题，为我国的生态文明建设，为改善人类生存与发展环境而努力。\n" +
//                "\n" +
//                "二、大赛主旨\n" +
//                "\n" +
//                "生态意识、生态科技、生态创新，助推生态文明\n" +
//                "\n" +
//                "三、大赛组织\n" +
//                "\n" +
//                "1. 主办单位：上海海洋大学教务处\n" +
//                "\n" +
//                "2. 承办单位：上海海洋大学海洋生态与环境学院。\n" +
//                "\n" +
//                "3. 海洋生态与环境学院成立大赛组委会，负责大赛相关事宜。\n" +
//                "\n" +
//                "四、参赛条件与方式\n" +
//                "\n" +
//                "1. 参赛条件\n" +
//                "\n" +
//                "（1）上海海洋大学正式注册的学生（含博士生、硕士生、本科生、留学生等）均可申报作品参赛，参赛者在报名参赛时需要提供有效的学生身份证明；\n" +
//                "\n" +
//                "（2）报名以小组方式参赛，要求每个小组成员不少于2人、不多于5人，成员只允许参加一个团队，成员及排序不能随意变更；每个团队需确定指导教师，且指导教师不多于2人；鼓励不同专业、研究方向学生组队。\n" +
//                "\n" +
//                "2. 参赛方式\n" +
//                "\n" +
//                "参赛队学生接到大赛通知后，即可按大赛主题和内容要求进行准备，最终完成作品的设计与制作，向组委会提交：\n" +
//                "\n" +
//                "（1）作品报名表；\n" +
//                "\n" +
//                "（2）科技论文作品或科技实物作品。\n" +
//                "\n" +
//                "3. 作品要求\n" +
//                "\n" +
//                "（1）若报名提交科技论文作品，应是围绕主题内涵的一种创意、理念、产品的虚拟概念设计，以论文的形式（须含虚拟概念设计图）提交，论文格式见“附件2：科技论文作品格式要求”。\n" +
//                "\n" +
//                "（2）若报名提交科技实物作品，应是体现大赛主题内涵的发明制造或者计算机软件作品，必须以实物照片或者软件的形式提交并附作品说明书，说明书格式见“附件3：实物作品说明书格式要求”。\n" +
//                "\n" +
//                "4. 作品原则与范围\n" +
//                "\n" +
//                "（1）基本原则\n" +
//                "\n" +
//                "作品符合国家现行法律和法规，内容真实可靠，选题具有科学性，结果具有创新性。\n" +
//                "\n" +
//                "（2）作品范围\n" +
//                "\n" +
//                "作品选题应是涉及基础生态、自然保护、生态工程、生态治理、生态修复、生态规划以及生态管理等领域相关热点问题的创新实验设计与研究。\n" +
//                "\n" +
//                "五、大赛议程\n" +
//                "\n" +
//                "1. 大赛报名\n" +
//                "\n" +
//                "报名时间：9月20日-11月10日24:00。\n" +
//                "\n" +
//                "报名方式：各参赛队自行下载《第一届环境生态科技创新大赛报名表》（参见附件1）通过电子邮件发送至杨丽丽老师邮箱llyang@shou.edu.cn，报名表命名为“作品名-年级专业-负责人姓名学号-学院”，如：“水体富营养化治理-2016级环境工程-张三160000001-海洋生态与环境学院”。\n" +
//                "\n" +
//                "2. 作品提交\n" +
//                "\n" +
//                "提交时间：报名日起接受作品提交，截止时间2018年11月10日24:00。\n" +
//                "\n" +
//                "提交方式：科技论文作品电子版以PDF或WORD两种格式提交论文；科技实物作品提交实物照片和作品说明书。各参赛队将电子版作品通过电子邮件发至杨丽丽老师邮箱llyang@shou.edu.cn，纸质稿打印一份（实物照片需彩打）交至海洋生态与环境学院B306。\n" +
//                "\n" +
//                "注：纸质版报名表和纸质版科技论文或科技实物作品照片一起提交。\n" +
//                "\n" +
//                "3. 评审公示\n" +
//                "\n" +
//                "大赛组委会将在12月10日完成所有作品评审（评审标准见附件4），并进行校内公示。\n" +
//                "\n" +
//                "六、大赛奖励\n" +
//                "\n" +
//                "本届大赛分别就科技学术论文和科技实物作品两个组别设立一等奖、二等奖、三等奖，按照参赛选手人数的3%、7%、10%分配，获奖选手颁发获奖证书和奖品。择优选取获奖者推荐参加全国大学生环境生态科技创新大赛。\n" +
//                "\n" +
//                "七、其他事项\n" +
//                "\n" +
//                "1. 所有参赛作品必须是参赛者原创作品。一旦发现参赛者存在侵权行为，大赛组委会有权取消其资格，由此产生的侵权法律后果及责任全部由参赛者承担。已确认获奖的产品存在侵权行为时，赛事组委会有权取消获奖资格并追回已发放的证书。\n" +
//                "\n" +
//                "2. 大赛组委会对本次大赛拥有最终解释权。\n" +
//                "\n" +
//                "附件1：第一届环境生态科技创新大赛报名表.docx\n" +
//                "\n" +
//                "附件2：科技论文作品格式要求.docx\n" +
//                "\n" +
//                "附件3：实物作品说明书格式要求.doc\n" +
//                "\n");
//        tzggContact.setDate("2018-09-21");
//        tzggContactDao.insert(tzggContact);
//        tzggContactDao.save(tzggContact);
        //cfbg添加
//        CfbgContactDao cfbgContactDao = daoSession.getCfbgContactDao();
//        CfbgContact cfbgContact = new CfbgContact();
//        cfbgContact.setTitle("关于水产与生命学院李晨虹1人赴德短期学术访问团出访报告");
//        cfbgContact.setData("出访报告信息表 \n" +
//                "团组基本信息 \n" +
//                "团组名称 水产与生命学院李晨虹1人赴德短期学术访问团 组团单位 上海海洋大学 \n" +
//                "批准人数 1 批准天数 12 批件号 沪府办外\n" +
//                "     【2018】7820号 团长或领队 李晨虹 \n" +
//                "填表人 李晨虹 联系电话 15692161233 填表\n" +
//                "     时间 2018.10.18 \n" +
//                "\u200B \n" +
//                "出访情况 \n" +
//                "离境日期 2018.10.8 抵境日期 2018.10.18 实际出访天数 11 \n" +
//                "批准出访国家、地区（含经停城市） 德国 \n" +
//                "实际出访国家、地区（含经停城市） 德国 \n" +
//                "出访人员名单 李晨虹 \n" +
//                "实际出访行程：        日期  时间                     内容\n" +
//                "     10月8日 全天 浦东国际机场1:20 – 德国慕尼黑机场7:10（CA827）\n" +
//                "     10月9日 上午 参观德国慕尼黑巴伐利亚邦动物学博物馆\n" +
//                "     10月9日 下午 研究巴伐利亚邦动物学博物馆馆藏标本\n" +
//                "     10月10日 上午 同 Straube博士进行学术交流\n" +
//                "     10月10日 下午 合作研究项目总结\n" +
//                "     10月11日 上午 赴德国耶拿大学\n" +
//                "     10月11日 下午 参加鲱形亚部早期进化研讨会，并作大会报告\n" +
//                "     10月12日 上午 和学术同行、学生进行学术交流\n" +
//                "     10月12日 下午 和学术同行、学生进行学术交流\n" +
//                "     10月13日 上午 和学术同行、学生进行学术交流\n" +
//                "     10月13日 下午 制定合作计划\n" +
//                "     10月14日 上午 赴德国波茨坦大学进行学术交流\n" +
//                "     10月14日 下午 参观德国波茨坦大学\n" +
//                "     10月15日 上午 和Michael Hofreiter 教授讨论研究计划\n" +
//                "     10月15日 下午 参观德国波茨坦大学，做学术报告\n" +
//                "     10月16日 上午 与Michael Hofreiter 教授修改文章\n" +
//                "     10月16日 下午 与Michael Hofreiter 教授修改文章\n" +
//                "     10月17日 上午 和Straube 博士分析数据，讨论实验结果\n" +
//                "     10月17日 下午 与Hofreiter 教授、Straube 博士共同制定研究合作计划\n" +
//                "     10月17日 晚上 德国泰格尔机场20:35 – 慕尼黑机场21:40（LH213）\n" +
//                "     慕尼黑机场22:20 – 浦东国际机场15:15（CA6226）\n" +
//                "     10月18日 下午 15:15 到达浦东国际机场 \n" +
//                "\n" +
//                "\n" +
//                "主要出访成果： 访问获得如下主要成果：\n" +
//                "     和巴伐利亚邦动物学标本馆的Nicolas   Straube博士讨论合作项目的研究结果，分析数据，修改论文稿件，探讨如何开发并应用单链建库获得福尔马林样本DNA数据。和Ulirich   Schliewen博士探讨在虾虎鱼和鲱形目鱼类系统分类研究方面的合作，以及交换组织样本的计划。\n" +
//                "     在耶拿大学做了题为“Resolving the phylogenetic interrelationships among the   clupeiforms using cross-species target gene   enrichment”的特邀报告（附录一）。同德国Deutsches博物馆的Timo Moritz博士、堪萨斯大学的Gloria   Arratia教授、马来西亚科技大学的Sebastien   Lavoue教授等进行了深入交谈，探讨了鲱形目鱼类的进化和分类研究现状和问题，和Moritz博士、Lavoue教授达成了合作协议。同参加德国鱼类学会年会的师生交流，建立了新的合作机会。\n" +
//                "     最后访问波茨坦大学Michael Hofreiter教授领导的进化基因组学实验室，同每一位研究人员，包括教授、博士后和研究生交谈，了解他们的研究方向，交换了最新研究心得。和Hofreiter教授讨论确定了合作研究意向和合作申请课题的计划。 \n" +
//                "需要说明的问题： 无 \n" +
//                "出访小结是否完成： 是 \n" +
//                "出访费用是否按规定核销： 此次访问全部费用由外方资助 \n" +
//                "\u200B \n" +
//                "护照管理情况 \n" +
//                "领取护照 1本 护照类型 因公普通护照 因公 港澳通行证 \u200B \n" +
//                "交回护照 1本 护照类型 因公普通护照 因公 港澳通行证 \u200B \n" +
//                "护照通行证是否在返回后7个工作日内交回 是 \n");
//        cfbgContact.setDate("2018-10-19");
//        cfbgContactDao.insert(cfbgContact);
//        cfbgContactDao.save(cfbgContact);
        //Xsjz
//        XsjzContactDao xsjzContactDao = daoSession.getXsjzContactDao();
//        XsjzContact xsjzContact = new XsjzContact();
//        xsjzContact.setTitle("蒋哲：美国商学院精选期刊推荐及投稿");
//        xsjzContact.setData("讲座题目：美国商学院精选期刊推荐及投稿\n" +
//                "\n" +
//                "主 讲 人：蒋哲EBSCO中国区高级培训师\n" +
//                "\n" +
//                "讲座时间：2019年3月12日（周二） 下午12:15——13:00\n" +
//                "\n" +
//                "讲座地点：经管学院408室\n" +
//                "\n" +
//                "EBSCO是美国EBSCO公司的全文数据库检索系统，目前有全文数据库10余个，我校图书馆已购买的数据库最有：①学术期刊全文数据库（Academic Search Premier，ASP）：收录有7888种学术期刊的文摘和索引，其中全文刊近4700种，同行评审刊3600多种；②商业资源全文数据库（Business Source Premier，BSP）：收录有 2,300 多种期刊的全文，其中同行评审刊1100多种；③ 食品科学全文数据库（Food Science Source，FSS）            共收录1420种出版物，其中220种全文期刊，1000种食品科学相关的产业/市场全文报告，40种全文参考书及其它。\n" +
//                "\n" +
//                "讲座内容：\n" +
//                "\n" +
//                "1、商学院案例检索：搜寻不只是关键词；\n" +
//                "\n" +
//                "2、轻松读懂英文学术论文：HTML全文在线翻译及英语朗读功能；\n" +
//                "\n" +
//                "3、美国知名商学院精选高质量期刊：推荐及投稿链接；\n" +
//                "\n" +
//                "4、高级检索：经济学期刊检索编码应用；\n" +
//                "\n" +
//                "5、个性化收藏文献：文件夹的利用；\n" +
//                "\n" +
//                "6、搜寻范例研讨Q&A。\n" +
//                "\n" +
//                "望广大师生踊跃参加！\n");
//        xsjzContact.setDate("2019-03-08");
//        xsjzContactDao.insert(xsjzContact);
//        xsjzContactDao.save(xsjzContact);
        initViews();
    }
    private void initViews() {
        scrollView = findViewById(R.id.main_content);
        RadioGroup radioGroup = findViewById(R.id.btn_guid);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        shouyePageFragment = new ShouyePageFragment();
        fragmentTransaction.replace(R.id.main_content,shouyePageFragment,fragmentsNames[0]);
        fragmentTransaction.addToBackStack(fragmentsNames[0]);
        fragmentTransaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction tempFragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.home:
                        if (shouyePageFragment == null) {
                            shouyePageFragment = new ShouyePageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,shouyePageFragment,fragmentsNames[0]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[0]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentHome = fragmentManager.findFragmentByTag(fragmentsNames[0]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentHome,fragmentsNames[0]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.jiaowu:
                        if (jiaowuPageFragment == null) {
                            jiaowuPageFragment = new JiaowuPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,jiaowuPageFragment,fragmentsNames[1]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[1]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[1]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[1]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.faxian:
                        if (faxianPageFragment == null) {
                            faxianPageFragment = new FaxianPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,faxianPageFragment,fragmentsNames[2]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[2]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[2]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[2]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.shezhi:
                        if (shezhiPageFragment == null) {
                            shezhiPageFragment = new ShezhiPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,shezhiPageFragment,fragmentsNames[3]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[3]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[3]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[3]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            fragmentManager.beginTransaction().detach(shouyePageFragment).commit();
            fragmentManager.beginTransaction().attach(shouyePageFragment).commit();
        }
        if (resultCode == 4){
            fragmentManager.beginTransaction().detach(jiaowuPageFragment).commit();
            fragmentManager.beginTransaction().attach(jiaowuPageFragment).commit();
        }
    }
}
