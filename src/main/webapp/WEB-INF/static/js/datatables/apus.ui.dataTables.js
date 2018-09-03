/*! DataTables Bootstrap integration
 * ©2011-2014 SpryMedia Ltd - datatables.net/license
 */

/**
 * DataTables integration for Bootstrap 3. This requires Bootstrap 3 and
 * DataTables 1.10 or newer.
 *
 * This file sets the defaults and adds options to DataTables to style its
 * controls using Bootstrap. See http://datatables.net/manual/styling/bootstrap
 * for further information.
 */
(function(window, document, undefined){

    var factory = function( $, DataTable ) {
        "use strict";


        /* Set the defaults for DataTables initialisation */
        $.extend( true, DataTable.defaults, {
            dom:
            "<'row'<'col-md-7 col-sm-7 col-xs-8 mytool'><'col-md-5 col-sm-5 col-xs-4'f>r>"+
            "t"+
            "<'row'<'col-md-6  col-sm-6 'i><'col-md-6 col-sm-6' p>>",
            renderer: 'bootstrap'
        } );


        /* Default class modification */
        $.extend( DataTable.ext.classes, {
            sWrapper:      "dataTables_wrapper form-inline dt-bootstrap",
            sFilterInput:  "form-control input-sm",
            sLengthSelect: "form-control input-sm",
            "sPaging": "sui-pagination paging_", /* Note that the type is postfixed */
        } );


        /* Bootstrap paging button renderer */
        DataTable.ext.renderer.pageButton.bootstrap = function ( settings, host, idx, buttons, page, pages ) {
            var api     = new DataTable.Api( settings );
            var classes = settings.oClasses;
            var lang    = settings.oLanguage.oPaginate;
            var btnDisplay, btnClass;

            var attach = function( container, buttons ) {
                var i, ien, node, button;
                var clickHandler = function ( e ) {
                    e.preventDefault();
                    if ( e.data.action !== 'ellipsis' ) {
                        api.page( e.data.action ).draw( false );
                    }
                };

                for ( i=0, ien=buttons.length ; i<ien ; i++ ) {
                    button = buttons[i];

                    if ( $.isArray( button ) ) {
                        attach( container, button );
                    }
                    else {
                        btnDisplay = '';
                        btnClass = '';

                        switch ( button ) {
                            case 'ellipsis':
                                btnDisplay = '&hellip;';
                                btnClass = 'disabled';
                                break;

                            case 'first':
                                btnDisplay = lang.sFirst;
                                btnClass = button + (page > 0 ?
                                        '' : ' disabled');
                                break;

                            case 'previous':
                                btnDisplay = lang.sPrevious;
                                btnClass = button + (page > 0 ?
                                        '' : ' disabled');
                                break;

                            case 'next':
                                btnDisplay = lang.sNext;
                                btnClass = button + (page < pages-1 ?
                                        '' : ' disabled');
                                break;

                            case 'last':
                                btnDisplay = lang.sLast;
                                btnClass = button + (page < pages-1 ?
                                        '' : ' disabled');
                                break;

                            default:
                                btnDisplay = button + 1;
                                btnClass = page === button ?
                                    'active' : '';
                                break;
                        }

                        if ( btnDisplay ) {
                            node = $('<li>', {
                                'class': classes.sPageButton+' '+btnClass,
                                'aria-controls': settings.sTableId,
                                'tabindex': settings.iTabIndex,
                                'id': idx === 0 && typeof button === 'string' ?
                                settings.sTableId +'_'+ button :
                                    null
                            } )
                                .append( $('<a>', {
                                    'href': '#'
                                } )
                                    .html( btnDisplay )
                            )
                                .appendTo( container );

                            settings.oApi._fnBindAction(
                                node, {action: button}, clickHandler
                            );
                        }
                    }
                }
            };

            attach(
                $(host).empty().html('<ul class="pagination"/>').children('ul'),
                buttons
            );
        };


        /*
         * TableTools Bootstrap compatibility
         * Required TableTools 2.1+
         */
        if ( DataTable.TableTools ) {
            // Set the classes that TableTools uses to something suitable for Bootstrap
            $.extend( true, DataTable.TableTools.classes, {
                "container": "DTTT btn-group",
                "buttons": {
                    "normal": "btn btn-default",
                    "disabled": "disabled"
                },
                "collection": {
                    "container": "DTTT_dropdown dropdown-menu",
                    "buttons": {
                        "normal": "",
                        "disabled": "disabled"
                    }
                },
                "print": {
                    "info": "DTTT_print_info modal"
                },
                "select": {
                    "row": "active"
                }
            } );

            // Have the collection use a bootstrap compatible drop down
            $.extend( true, DataTable.TableTools.DEFAULTS.oTags, {
                "collection": {
                    "container": "ol",
                    "button": "li",
                    "liner": "a"
                }
            } );
        }

    }; // /factory


// Define as an AMD module if possible
    if ( typeof define === 'function' && define.amd ) {
        define( ['jquery', 'datatables'], factory );
    }
    else if ( typeof exports === 'object' ) {
        // Node/CommonJS
        factory( require('jquery'), require('datatables') );
    }
    else if ( jQuery ) {
        // Otherwise simply initialise as normal, stopping multiple evaluation
        factory( jQuery, jQuery.fn.dataTable );
        apus.ui.dataTables = function (dom, config) {
            var params = {
                ordering:false,
                "ajax": {
                    dataSrc: function (resp) {
                        //session过期处理
                        if (resp.data && resp.data == '请求过期') {
                            window.location.reload();
                            return;
                        }
                        return resp.data;
                    }
                },
                "processing": true,
                "serverSide": true,
                "language": {
                    "lengthMenu": "每页显示 _MENU_ 记录",
                    "zeroRecords": "对不起，查询不到任何相关数据",
                    "info": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                    "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "infoFiltered": "(数据表中共为 _MAX_ 条记录)",

                    "search": "搜索：",
                    //加载中效果
                    "processing": '<div class="ui-loader"><div class="loadingCircle"><div class="sui-loading loading-large"><i class="sui-icon icon-pc-loading"></i></div></div></div>',
                    "aaSorting": [[1, "desc"]],  //第一个参数表示表示Browser列。第二个参数为 desc或是asc
                    "paginate": {
                        "first": "首页",
                        "previous": "上一页 ",
                        "next": "下一页 ",
                        "last": "尾页 "
                    }
                },
                "autoWidth": false
            };

            $.extend(true, params, config);
            return $(dom).DataTable(params);
        }
    }


})(window, document);




