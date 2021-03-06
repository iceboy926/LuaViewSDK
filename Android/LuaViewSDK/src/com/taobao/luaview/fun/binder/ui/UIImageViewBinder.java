package com.taobao.luaview.fun.binder.ui;

import com.taobao.luaview.fun.base.BaseFunctionBinder;
import com.taobao.luaview.fun.base.BaseVarArgUICreator;
import com.taobao.luaview.fun.mapper.ui.UIImageViewMethodMapper;
import com.taobao.luaview.view.LVImageView;
import com.taobao.luaview.view.interfaces.ILVView;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.LibFunction;

/**
 * Image 图片
 * @author song
 */
public class UIImageViewBinder extends BaseFunctionBinder {

    public UIImageViewBinder() {
        super("Image");
    }

    @Override
    public Class<? extends LibFunction> getMapperClass() {
        return UIImageViewMethodMapper.class;
    }

    @Override
    public LuaValue createCreator(LuaValue env, LuaValue metaTable) {
        return new BaseVarArgUICreator(env.checkglobals(), metaTable) {
            @Override
            public ILVView createView(Globals globals, LuaValue metaTable, Varargs varargs) {
                return new LVImageView(globals, metaTable, varargs);
            }
        };
    }

}
