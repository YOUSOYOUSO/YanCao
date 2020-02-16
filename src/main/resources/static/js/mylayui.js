layui.use(['form', 'layedit', 'laydate','element'], function() {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;
    var $ = layui.jquery;

    form.val('first', {
        'xiangqizhi':document.getElementById("xiangqizhiv").value
    });
    form.val('first', {
        'xiangqiliang':document.getElementById("xiangqiliangv").value
    });
    form.val('first', {
        'zaqi':document.getElementById("zaqiv").value
    });
    form.val('first', {
        'cijixing':document.getElementById("cijixingv").value
    });
    form.val('first', {
        'yuwei':document.getElementById("yuweiv").value
    });
    form.val('first', {
        'ranshaoxing':document.getElementById("ranshaoxingv").value
    });
    form.val('first', {
        'huise':document.getElementById("huisev").value
    });
    form.val('first', {
        'nongdu':document.getElementById("nongduv").value
    });
    form.val('first', {
        'jintou':document.getElementById("jintouv").value
    });
    form.val('first', {
        'chengtuanxing':document.getElementById("chengtuanxingv").value
    });
    form.val('first', {
        'xinidu':document.getElementById("xiniduv").value
    });
    form.val('first', {
        'huitiangan':document.getElementById("huitianganv").value
    });
    form.val('first', {
        'ganzaodu':document.getElementById("ganzaoganv").value
    });
    form.val('first', {
        'yanse_zt':document.getElementById("yanse_ztv").value
    });
    form.val('first', {
        'chengshudu_zt':document.getElementById("chengshudu_ztv").value
    });
    form.val('first', {
        'youfen_zt':document.getElementById("youfen_ztv").value
    });
    form.val('first', {
        'jiegou_zt':document.getElementById("jiegou_ztv").value
    });
    form.val('first', {
        'shenfen_zt':document.getElementById("shenfen_ztv").value
    });
    form.val('first', {
        'sedu_zt':document.getElementById("sedu_ztv").value
    });
    var yanses = {
        "0":[],
        "1": ["8", "9", "10", "11", "12", "13"],
        "2": ["11", "12", "13", "14", "15"],
        "3": ["10", "11", "12", "13", "14"],
        "4": ["6", "7", "8", "9", "10"],
        "5": ["6", "7", "8"],
        "6": ["4", "5"],
        "7": ["2", "3"],
        "8": ["1", "2"]
    };
    var chengshudus =
        {
            "0":[],
            "1": ["18", "19", "20"],
            "2": ["16", "17", "18", "19", "20"],
            "3": ["11", "12", "13", "14", "15"],
            "4": ["4", "5", "6", "7", "8", "9", "10"],
            "5": ["1", "2", "3"]
        };
    var youfens =
        {
            "0":[],
            "1": ["21", "22", "23", "24", "25"],
            "2": ["16", "17", "18", "19", "20"],
            "3": ["11", "12", "13", "14", "15"],
            "4": ["5", "6", "7", "8", "9", "10"],
            "5": ["1", "2", "3", "4"]
        };

    var jiegous =
        {
            "0":[],
            "1":["11","12","13","14","15"],
            "2":["8","9","10"],
            "3":["4","5","6","7"],
            "4":["1","2","3"]
        };
    var shenfens =
        {
            "0":[],
            "1":["8","9","10"],
            "2":["5","6","7"],
            "3":["6","7"],
            "4":["2","3","4"],
            "5":["3","4"]
        };
    var sedus =
        {
            "0":[],
            "1":["13","14","15"],
            "2":["9","10","11","12"],
            "3":["6","7","8","9"],
            "4":["3","4","5"],
            "5":["1","2","3"]
        };
    var str =document.getElementById("yanse_ztv").value;
    var scores= yanses[str];
    $('#yanse_pf').html('');
    $('#yanse_pf').append('<option value="0">请选择评分</option>');
    var num=1;
    for (var i in scores){
        $('#yanse_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }
    str =document.getElementById("chengshudu_ztv").value;
    scores= chengshudus[str];
    $('#chengshudu_pf').html('');
    $('#chengshudu_pf').append('<option value="0">请选择评分</option>');
    num=1;
    for (var i in scores){
        $('#chengshudu_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }

    str =document.getElementById("youfen_ztv").value;
    scores= youfens[str];
    $('#youfen_pf').html('');
    $('#youfen_pf').append('<option value="0">请选择评分</option>');
    num=1;
    for (var i in scores){
        $('#youfen_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }
    str =document.getElementById("jiegou_ztv").value;
    scores= jiegous[str];
    $('#jiegou_pf').html('');
    $('#jiegou_pf').append('<option value="0">请选择评分</option>');
    num=1;
    for (var i in scores){
        $('#jiegou_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }
    str =document.getElementById("shenfen_ztv").value;
    scores= shenfens[str];
    $('#shenfen_pf').html('');
    $('#shenfen_pf').append('<option value="0">请选择评分</option>');
    num=1;
    for (var i in scores){
        $('#shenfen_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }
    str =document.getElementById("sedu_ztv").value;
    scores= sedus[str];
    console.log(scores);
    $('#sedu_pf').html('');
    $('#sedu_pf').append('<option value="0">请选择评分</option>');
    num=1;
    for (var i in scores){
        $('#sedu_pf').append('<option value='+num+' >' + scores[i] + '</option>');
        num++;
    }
    form.val('first', {
        'yanse_pf':document.getElementById("yanse_pfv").value
    });
    form.val('first', {
        'chengshudu_pf':document.getElementById("chengshudu_pfv").value
    });
    form.val('first', {
        'youfen_pf':document.getElementById("youfen_pfv").value
    });
    form.val('first', {
        'jiegou_pf':document.getElementById("jiegou_pfv").value
    });
    form.val('first', {
        'shenfen_pf':document.getElementById("shenfen_pfv").value
    });
    form.val('first', {
        'sedu_pf':document.getElementById("sedu_pfv").value
    });

    form.on('select(yanse_zt)', function(data){
        var scores= yanses[data.value];
        $('#yanse_pf').html('');
        $('#yanse_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#yanse_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }
        form.val('first', {
            'yanse_pf':'0'
        });
    });
    form.on('select(chengshudu_zt)', function(data){
        var scores= chengshudus[data.value];
        console.log(scores);
        $('#chengshudu_pf').html('');
        $('#chengshudu_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#chengshudu_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }
        var thisValue = form.val('first', {
            'chengshudu_pf':'0'
        });
    });
    form.on('select(youfen_zt)', function(data){
        var scores= youfens[data.value];
        $('#youfen_pf').html('');
        $('#youfen_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#youfen_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }
        form.val('first', {
            'youfen_pf':'0'
        });
    });
    form.on('select(jiegou_zt)', function(data){
        var scores= jiegous[data.value];
        $('#jiegou_pf').html('');
        $('#jiegou_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#jiegou_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }
        form.val('first', {
            'jiegou_pf':'0'
        });
    });
    form.on('select(shenfen_zt)', function(data){
        var scores= shenfens[data.value];
        $('#shenfen_pf').html('');
        $('#shenfen_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#shenfen_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }

        form.val('first', {
            'shenfen_pf':'0'
        });
    });
    form.on('select(sedu_zt)', function(data){
        var scores= sedus[data.value];
        console.log(scores);
        $('#sedu_pf').html('');
        $('#sedu_pf').append('<option value="0">请选择评分</option>');
        var temp=1;
        for (var i in scores){
            $('#sedu_pf').append('<option value='+temp+' >' + scores[i] + '</option>');
            temp++;
        }

       form.val('first', {
            'sedu_pf':'0'
        });
    });


});