package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);

    private String insertUrl="/com";
    private String oneUrl = "/com/{id}";
    private String allUrl = "/coms";
    private String updateUrl ="/com";
    private String updateNameUrl = "/com";
    private String deleteUrl = "/com/{id}";
    @Before
    public void setUp() {
        //指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    /**
     * 1、mockMvc.perform执行一个请求。
     * 2、MockMvcRequestBuilders.get("XXX")构造一个请求
     * 3、ResultActions.param添加请求传值
     * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
     * 5、ResultActions.andExpect添加执行完成后的断言
     * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
     * 比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
     * 7、ResultActions.andReturn表示执行完成后返回相应的结果
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception{
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();

        params.add("com_name","华为手机P31");
        params.add("com_price","4999");
        params.add("com_description","这是980处理器的手机");
        String content =
                mockMvc.perform(MockMvcRequestBuilders.post(insertUrl).params(params))
                        .andReturn().getResponse().getContentAsString();
        LOGGER.info("contend：{}",content);
    }

    @Test
    public void findOne() throws Exception {
        String com = mockMvc.perform(MockMvcRequestBuilders.get(oneUrl,2))
                .andReturn().getResponse().getContentAsString();
        LOGGER.info("book:{}",com);
    }

    @Test
    public void findAll() throws Exception{
        String list = mockMvc.perform(MockMvcRequestBuilders.get(allUrl))
                .andReturn().getResponse().getContentAsString();
        LOGGER.info("list:{}",list);
    }

    @Test
    public void update() throws Exception {
        final MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("com_id","4");
        params.add("com_name","华为手机");
        params.add("com_price","3500");
        params.add("com_description","价格公道");
        String content = mockMvc.perform(MockMvcRequestBuilders.put(updateUrl).params(params))
                .andReturn().getResponse().getContentAsString();

        LOGGER.info("content:{}", content);
    }

    @Test
    public void patch() throws Exception {
        final MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("com_id","2");
        params.add("com_name","华为Mate30Pro");
        String content = mockMvc.perform(MockMvcRequestBuilders.patch(updateNameUrl).params(params))
                .andReturn().getResponse().getContentAsString();
        LOGGER.info("content:{}", content);
    }

    @Test
    public void delete() throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.delete(deleteUrl, "7"))
                .andReturn().getResponse().getContentAsString();
        LOGGER.info("content:{}", content);
    }
}
