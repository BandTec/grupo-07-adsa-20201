/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slack;

import java.io.Serializable;
import lombok.*;

/**
 *
 * @author Pichau
 */
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Getter
@Setter
public class SlackMessage implements Serializable{
    private String user;
    private String text;
    private String icon_emoji;
    private String channel;
}
