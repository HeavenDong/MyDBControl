package com.example.administrator.mydbcontrol;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;
import de.greenrobot.dao.query.QueryBuilder;

import static com.example.administrator.mydbcontrol.DaoMaster.createAllTables;

/**
 *
 * 备注：当不需要一张表的时候：可以在模板创建的额时候不掉调用某一个的创建方法:在文件路径中 没有在创建模板中写的dao存在：但是master和session不再关联了
 * 也可以在这个manager中删除一张表：
 */
public class DBManager {
    private static DBManager dbManger;
    private tb_cityDao cityDao;
    private tb_provinceDao provinceDao;
    private SQLiteDatabase db;
    private DBManager(){
        DaoSession mDaoSession= App.getAppInsatnce().getDaoSession();
        cityDao= mDaoSession.getTb_cityDao();
        provinceDao=mDaoSession.getTb_provinceDao();
    }
    public static DBManager getDBManager(){
        if (dbManger==null){
            dbManger=new DBManager();
            Log.e("haifeng", "创建DBManager");
        }else {
            Log.e("haifeng", "已存在DBManager");
        }
        return dbManger;
    }
    public List<tb_city> selectCityList() {
        Log.e("haifeng",  "查询city表");
        QueryBuilder<tb_city> qb = cityDao.queryBuilder();
        return qb.list();
    }

    public List<tb_province> selectProvinceList() {
        Log.e("haifeng",  "查询province表");
        QueryBuilder<tb_province> qb = provinceDao.queryBuilder();
        return qb.list();
    }



//    /**增*/
//    public void insertHomeList(HomeListEntity entity){
//        homeListEntityDao.insert(entity);
////        MyLogs.e("haifeng", "插入Home表");
//    }
//    public void insertGiftRecommentList(GiftRecommentEntity entity){
//        giftRecommentEntityDao.insert(entity);
////        MyLogs.e("haifeng", "插入recommend表");
//    }
//    public void insertGiftClassifyList(GiftClassifyEntity entity){
//        giftClassifyEntityDao.insert(entity);
////        MyLogs.e("haifeng", "插入classify表");
//    }
//    public void insertGiftStrategyList(GiftStrategyEntity entity){
//        giftStrategyEntityDao.insert(entity);
////        MyLogs.e("haifeng", "插入strategy表");
//    }
//    /**删*/
//    public  void clearHomeList(){
//        if(homeListEntityDao.count()>0) {
//            homeListEntityDao.deleteAll();
//            MyLogs.e("haifeng", "清Home表");
//        }
//    }
//    public  void clearGiftRecommentList(){
//        giftRecommentEntityDao.deleteAll();
//        MyLogs.e("haifeng","");
//    }
//    public  void clearGiftClassifyList(){
//        giftClassifyEntityDao.deleteAll();
//        MyLogs.e("haifeng","");
//    }
//    public  void clearGiftStrategyList(){
//        giftStrategyEntityDao.deleteAll();
//        MyLogs.e("haifeng","");
//    }
//    //删除一条
//    public void deleteHomesListItem(int Id)
//    {
//        QueryBuilder<HomeListEntity> qb = homeListEntityDao.queryBuilder();
//        DeleteQuery<HomeListEntity> bd = qb.where(HomeListEntityDao.Properties.Id.eq(Id)).buildDelete();
//        bd.executeDeleteWithoutDetachingEntities();
//    }
//
//    /**改*/
//    public void updateHomesList(HomeListEntity homeListEntity) {
//        homeListEntityDao.insertOrReplace(homeListEntity);
//        homeListEntityDao.insertInTx(homeListEntity);
//        MyLogs.e("haifeng",  "修改数据");
//    }
//    /**查*/
//    public List<HomeListEntity> selectHomeList() {
//        MyLogs.e("haifeng",  "查询Home表");
//        QueryBuilder<HomeListEntity> qb = homeListEntityDao.queryBuilder();
//        return qb.list();
//    }
//    public List<GiftRecommentEntity> selectGiftRecommendList() {
//        MyLogs.e("haifeng",  "查询所有数据");
//        QueryBuilder<GiftRecommentEntity> qb = giftRecommentEntityDao.queryBuilder();
//        return qb.list();
//    }
//    public List<GiftClassifyEntity> selectGiftClassifyList() {
//        MyLogs.e("haifeng",  "查询所有数据");
//        QueryBuilder<GiftClassifyEntity> qb = giftClassifyEntityDao.queryBuilder();
//        return qb.list();
//    }
//
//    public List<GiftStrategyEntity> selectGiftStrategyList() {
//        MyLogs.e("haifeng",  "查询所有数据");
//        QueryBuilder<GiftStrategyEntity> qb = giftStrategyEntityDao.queryBuilder();
//        return qb.list();
//    }


//    //获取某列对象
//    public FriendsEntity getFriendsListItem(int ID) {
//        MyLogs.e("haifeng", "表：查好友id 为" + ID + "的数据");
//        return friendsEntityDao.loadByRowId(ID);
//    }
//    // 查询某个表是否包含某个id
//    public boolean isSaved(int ID) {
//        QueryBuilder<FriendsEntity> qb = friendsEntityDao.queryBuilder();
//        qb.where(FriendsEntityDao.Properties.FriendsId.eq(ID));
//        qb.buildCount().count();
//        MyLogs.e("haifeng", "表：查好友id 为" + ID + "的数据是否存在");
//        return qb.buildCount().count() > 0 ? true : false;
//    }
//    //通过一个字段值查找对应的另一个字段值(为简便直接使用下面方法，也许有更简单的方法，尚未尝试)
//    public String getTypeId(int ID){
//        QueryBuilder<FriendsEntity> qb = friendsEntityDao.queryBuilder();
//        qb.where(FriendsEntityDao.Properties.FriendsId.eq(ID));
//        MyLogs.e("haifeng", "表：查好友id 为" + ID + "的人的昵称");
//        if (qb.list().size() > 0)
//        {
//            return qb.list().get(0).getNickName();
//        }
//        else
//        {
//            return "";
//        }
//    }
//    // 查找所有第一姓名是“Joe”并且以Mobile排序。
//    public  List<FriendsEntity> queryListItem(String nickName){
//        return friendsEntityDao.queryBuilder()
//                .where(FriendsEntityDao.Properties.NickName.eq(nickName))
//                .orderAsc(FriendsEntityDao.Properties.Mobile)
//                .list();
//    }
//    // 多重条件查询
//    public List<FriendsEntity> getSupportingList(int sex,String name) {
//        QueryBuilder<FriendsEntity> qb = friendsEntityDao.queryBuilder();
//        qb.where(qb.and(FriendsEntityDao.Properties.Gender.eq(sex), FriendsEntityDao.Properties.NickName.eq(name)));
//        qb.orderAsc(FriendsEntityDao.Properties.Id);// 排序依据
//        return qb.list();
//    }
}
