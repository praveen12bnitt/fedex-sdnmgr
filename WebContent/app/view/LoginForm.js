Ext.define('SdnMgr.view.LoginForm', {
    extend: 'Ext.form.Panel',
	xtype: 'sdn.login',
    frame:true,
    width: 320,
    bodyPadding: 10,
        
    defaultType: 'textfield',
    
    items: [{
        allowBlank: false,
        fieldLabel: 'User ID',
        name: 'user',
        emptyText: 'User Id'
    }, {
        allowBlank: false,
        fieldLabel: 'Password',
        name: 'pass',
        emptyText: 'Password',
        inputType: 'password'
    }, {
        xtype:'checkbox',
        fieldLabel: 'Remember me',
        name: 'remember'
    }],
    
    buttons: [
        { text:'Register' },
        { 
        	text:'Login',
        	handler: function(btn) {
        		var card = btn.up('#cardPanel');
        		//btn.up('window').hide();
        		//viewport.down('#customerPortalMain').show();        		
        		card.getLayout().setActiveItem(1);
        	}
        }
    ],
    
    initComponent: function() {
        this.defaults = {
            anchor: '100%',
            labelWidth: 100
        };
        
        this.callParent();
    }
});