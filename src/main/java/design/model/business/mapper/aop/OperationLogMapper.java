package design.model.business.mapper.aop;

import design.model.business.domain.entity.UserOperationLogEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {

    int insert( UserOperationLogEntity userOperationLogEntity);
}
