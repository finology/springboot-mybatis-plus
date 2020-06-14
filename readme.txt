1. 数据库连接池 - Done
2. Mybatis Plus - 需要下载官方 sample 全面学习
3. Mybatis 翻页
4. BaseMapper, BaseService
5. 日志打印 sql
6. AOP 日志打印接口耗时
7. 异常 - 先查看AI文件管理系统的处理方法后，再学习两个视频中的方法 @RestControllerAdvice

1. 通用返回类设计

BaseResponse<T> {
    int code
    string message
    T data
}

3. 跨域
5. 日志配置打印
6. 事务（上传、写数据库）
8. 时区问题
9. 翻页问题， pagehelper
11. 划分项目模块
权限问题，有个视频 Spring security

划分模块，使用feign client，和 spring security 的划分模块比较一下。

请求类 AddUserRequest，返回类 AddUserResponse (带 code, message)，Model User
从数据库查出来的，要么直接用PO User, 如果联合查询，那就返回 UserInfo, 带一些其他参数。输入参数都用PO (完美)
