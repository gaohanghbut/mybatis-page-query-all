package cn.yxffcode.mybatispagequeryall;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author gaohang on 16/8/4.
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class,
                        CacheKey.class, BoundSql.class}), @Signature(type = Executor.class, method = "update",
        args = {MappedStatement.class, Object.class})})
public class PageQueryAllInterceptor implements Interceptor {
    @Override public Object intercept(final Invocation invocation) throws Throwable {
        return null;
    }

    @Override public Object plugin(final Object target) {
        return null;
    }

    @Override public void setProperties(final Properties properties) {

    }
}
