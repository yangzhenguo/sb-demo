package com.yangzg.demo.demo1.property;

import com.yangzg.demo.demo1.model.Anchor;
import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2020/1/21.
 * @author Sam
 */
@Data
@Component
@ConfigurationProperties(prefix = "anchor")
public class AnchorProperties {
    private Anchor[] users;

    private static volatile Map<Integer, Anchor> map;

    public Map<Integer, Anchor> getMap() {
        if (map == null) {
            synchronized (AnchorProperties.class) {
                if (map == null) {
                    map = Arrays.stream(users).collect(Collectors.toMap(Anchor::getId, anchor -> anchor));
                }
            }
        }
        return map;
    }
}
