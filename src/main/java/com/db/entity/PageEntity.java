package com.db.entity;

/**
 * 分页实体
 */
public class PageEntity {

    //已知数据
//private int pageNum;    //当前页,从请求那边传过来。
//private int pageSize;    //每页显示的数据条数。
//private int totalRecord;    //总的记录条数。查询数据库得到的数据
////需要计算得来
//private int totalPage;    //总页数，通过totalRecord和pageSize计算可以得来
////开始索引，也就是我们在数据库中要从第几行数据开始拿，有了startIndex和pageSize，
////就知道了limit语句的两个数据，就能获得每页需要显示的数据了
//private int startIndex;
////将每页要显示的数据放在list集合中
//private List<T> list;//分页显示的页数,比如在页面上显示1，2，3，4，5页，start就为1，end就为5，这个也是算过来的
//private int start;
//private int end;
////通过pageNum，pageSize，totalRecord计算得来tatalPage和startIndex
////构造方法中将pageNum，pageSize，totalRecord获得
//public PageBean(int pageNum,int pageSize,int totalRecord) {
//  this.pageNum = pageNum;
//  this.pageSize = pageSize;
//  this.totalRecord = totalRecord;
//   //totalPage 总页数
//   if(totalRecord%pageSize==0){
//      //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
//       this.totalPage = totalRecord / pageSize;
//   }else{
//       //不整除，就要在加一页，来显示多余的数据。
//       this.totalPage = totalRecord / pageSize +1;
//    }
////开始索引
//   this.startIndex = (pageNum-1)*pageSize ;
////显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
//    this.start = 1;
//    this.end = 5;
//        45         //显示页数的算法
//        46
//        47         if(totalPage <=5){
//            48             //总页数都小于5，那么end就为总页数的值了。
//            49             this.end = this.totalPage;
//            50         }else{
//            51             //总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了，
//            52             this.start = pageNum - 2;
//            53             this.end = pageNum + 2;
//            54
//            55             if(start < 0){
//                56                 //比如当前页是第1页，或者第2页，那么就不如和这个规则，
//                57                 this.start = 1;
//                58                 this.end = 5;
//                59             }
//            60             if(end > this.totalPage){
//                61                 //比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
//                62                 this.end = totalPage;
//                63                 this.start = end - 5;
//                64             }
//            65         }
//        66     }
// 67 //get、set方法。
//         68     public int getPageNum() {
//        69         return pageNum;
//        70     }
// 71
//         72     public void setPageNum(int pageNum) {
//        73         this.pageNum = pageNum;
//        74     }
// 75
//         76     public int getPageSize() {
//        77         return pageSize;
//        78     }
// 79
//         80     public void setPageSize(int pageSize) {
//        81         this.pageSize = pageSize;
//        82     }
// 83
//         84     public int getTotalRecord() {
//        85         return totalRecord;
//        86     }
// 87
//         88     public void setTotalRecord(int totalRecord) {
//        89         this.totalRecord = totalRecord;
//        90     }
// 91
//         92     public int getTotalPage() {
//        93         return totalPage;
//        94     }
// 95
//         96     public void setTotalPage(int totalPage) {
//        97         this.totalPage = totalPage;
//        98     }
// 99
//         100     public int getStartIndex() {
//        101         return startIndex;
//        102     }
//103
//        104     public void setStartIndex(int startIndex) {
//        105         this.startIndex = startIndex;
//        106     }
//107
//        108     public List<T> getList() {
//        109         return list;
//        110     }
//111
//        112     public void setList(List<T> list) {
//        113         this.list = list;
//        114     }
//115
//        116     public int getStart() {
//        117         return start;
//        118     }
//119
//        120     public void setStart(int start) {
//        121         this.start = start;
//        122     }
//123
//        124     public int getEnd() {
//        125         return end;
//        126     }
//127
//public void setEnd(int end) {
//  this.end = end;
//}


}
