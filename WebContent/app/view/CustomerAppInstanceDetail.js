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
    	
    items: [{
    	xtype: 'gridpanel',
    	flex: 1,
    	columns: [{
    		dataIndex: 'name',
    		text: 'Fix Pack Name',
    		flex: 1
    	}, {
    		dataIndex: 'applied',
    		text: 'Applied',
    		flex: 1,
    		align: 'center',
    		xtype: 'actioncolumn',
    		getClass: function (record) {
		    			if(record.get('applied'))
		    				return 'applied-icon-cls';
		    			else
		    				return 'pending-icon-cls';
		    		}
    		}, {
    			dataIndex: 'publishDate',
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
            fields: ['fixpack', 'data' ],
            data: [
                { fixpack: 'Applied Fixpacks', data: 8},
                { fixpack: 'Pending Fixpacks', data: 2},
            ]
        }),
        insetPadding: 40,
        legend: {
            field: 'fixpack',
            position: 'bottom',
            boxStrokeWidth: 0,
            labelFont: '12px Helvetica'
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
                fill: '#000',
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