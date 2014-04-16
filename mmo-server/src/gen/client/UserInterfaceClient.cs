using UnityEngine;
using System.Collections;
using System;
public abstract class UserInterfaceClient {
	protected BaseChannel channel;
	private int sn=0;
	public void dispath(RpcInput input){
		int cmd=input.readInt();
		switch(cmd){
			case 1 :{
				_login(input,sn);
				return;
			}
			case 2 :{
				_closeUser(input,sn);
				return;
			}
		}
	}
	public  void login(String name,String password){
		RpcOutput buffer=new RpcOutput();
		buffer.writeInt(1);
		buffer.writeInt(1);
		buffer.writeInt(sn++);
		buffer.writeString(name);
		buffer.writeString(password);
		channel.writeRpcOutput(buffer);
	}
	public  void closeUser(String name){
		RpcOutput buffer=new RpcOutput();
		buffer.writeInt(1);
		buffer.writeInt(2);
		buffer.writeInt(sn++);
		buffer.writeString(name);
		channel.writeRpcOutput(buffer);
	}
	private void _login(RpcInput input,int sn){
		int state=input.readInt();
		Vos.UserVO result=new Vos.UserVO();
		result.read(input);
		loginCallback(state,result);
	}
	private void _closeUser(RpcInput input,int sn){
		int state=input.readInt();
		Vos.UserVO result=new Vos.UserVO();
		result.read(input);
		closeUserCallback(state,result);
	}
	public abstract void loginCallback(int state,Vos.UserVO result);

	public abstract void closeUserCallback(int state,Vos.UserVO result);

}
