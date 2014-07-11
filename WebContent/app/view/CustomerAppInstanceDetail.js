Ext.define('SdnMgr.view.CustomerAppInstanceDetail', {
    extend: 'Ext.panel.Panel', 
    xtype: 'appinstance.detail',
    cls: 'customer-instance-detail',
    
    requires: [
               'SdnMgr.store.FixPacks',
               'Ext.chart.Chart',
               'Ext.chart.series.Pie'
           ],
    
    layout: {
    	type: 'vbox',
    	align: 'stretch'
    },
    border: false,
    
    bodyPadding: 5,
    
    controller: 'customerinstance',
    	
    items: [{
    	xtype: 'gridpanel',
    	reference: 'sdnList',
    	store: Ext.create('SdnMgr.store.FixPacks'),
    	flex: 1,
    	columns: [{
    		dataIndex: 'name',
    		text: 'Fix Pack Name',
    		flex: 1
    	}, {
    		text: 'Applied',
    		flex: 1,
    		dataIndex: 'applied',
    		renderer : function(value) {
					if (value)
						return '<span style="color:green">Yes</span>';
					else
						return '<span style="color:red">No</span>';
				}
    		}, {
    			dataIndex: 'publishDate',
    			renderer : function(value) {
					return Ext.Date.format(new Date(value), 'm/d/Y H:i:s');
				},
    			text: 'Published Date',
    			flex: 1
    		}]
    }, {
        xtype: 'chart',
        flex: 1,
        style: 'background: #fff',
        animate: true,
        shadow: false,
        store: Ext.create('Ext.data.JsonStore', {
        	storeId: 'chartData',
            fields: ['fixpack', 'data' ]
        }),
        insetPadding: 40,
        legend: {
            field: 'fixpack',
            position: 'bottom',
            boxStrokeWidth: 0,
            labelFont: '12px Segoe UI'
        },
        series: [{
            type: 'pie',
            angleField: 'data',
            donut: 50,
            label: {
                field: 'fixpack',
                display: 'outside',
                calloutLine: true
            },
            showInLegend: true,
            highlight: {
                fill: 'orange',
                'stroke-width': 1,
                stroke: '#ccc'
            },
            tips: {
                trackMouse: true,
                style: 'background: #FFF',
                height: 20,
                renderer: function(storeItem, item) {
                    this.setTitle(storeItem.get('fixpack') + ': ' + storeItem.get('data'));
                }
            }
        }]
    }]

});