package controller;


import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.TPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Tag(name = "支付接口",description = "支付CRUD")
public class PayController {

    @Resource
    private TPayService tPayService;

    @PostMapping("/pay/add")
    @Operation(summary = "添加支付记录")
    public ResultData<String> addPay(@RequestBody PayDTO payDTO) {
        try {
            TPay tpay = new TPay();
            BeanUtils.copyProperties(payDTO,tpay);
            return ResultData.success(tPayService.getBaseMapper().insert(tpay)+ "条记录");
        } catch (Exception e) {
            return ResultData.fail(ReturnCodeEnum.PARAM_ERROR.getCode(),e.getMessage());
        }
    }

    @DeleteMapping("/pay/delete/{id}")
    @Operation(summary = "删除支付记录")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        return ResultData.success(tPayService.getBaseMapper().deleteById(id));
    }

    @PostMapping("/pay/update")
    @Operation(summary = "修改支付记录")
    public ResultData<String> updatePay(@RequestBody TPay tPay) {
        String res = tPayService.getBaseMapper().updateById(tPay)+ "条记录";
        return ResultData.success(res);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "获取支付记录")
    public ResultData<PayDTO> getPaybyId(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(tPayService.getById(id), payDTO);
        return ResultData.success(payDTO);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/getinfo")
    public String getInfoByConsul(@Value("${server.port}") String atguiguInfo) {
        return "atguiguInfo："+atguiguInfo+"\t"+"server.port："+port;
    }
}
