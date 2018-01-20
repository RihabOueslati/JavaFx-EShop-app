/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.dao.interfaces;

import java.util.ArrayList;
import com.dealforall.div.entities.Message;

/**
 *
 * @author reznov
 */
public interface IMessagerieDAO {
    public boolean sendMessage(Message m);
    public ArrayList<Message> getMessages(int type); // 0- Unread **** 1- Read messages
    public int countMessages(int type);// 0- Unread **** 1- Read messages
    public void readMessage(String content);    
}
