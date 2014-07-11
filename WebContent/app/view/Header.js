Ext.define('SdnMgr.view.Header', {
    extend: 'Ext.Container',
    alias: 'widget.appHeader',
    itemId: 'app-header',
    cls: 'header',    
    height: 50,
    layout: {
        type: 'hbox',
        align: 'middle'
    },

    initComponent: function() {
    	var me = this;
        this.items = [{
        	xtype: 'image',
        	width: 24,
        	height: 24,
        	margin: '0 10',
        	src: 'resources/icons/download.png'
        }, {
            xtype: 'label',
            itemId: 'app-header-title',
            cls: 'app-header-text',
            text: 'SDN Manager',
            flex: 1
        }, {
        	xtype: 'button',
        	style: {
        		float: 'right'
        	},
        	text: 'Home',
        	margin: '0 10',
        	scale: 'medium',
        	handler: function () {
        		var cardPanel = me.ownerCt.getComponent('cardPanel');
            	cardPanel.getLayout().setActiveItem('customerView');
        	}
        }];

        this.callParent(arguments);
    }
});
