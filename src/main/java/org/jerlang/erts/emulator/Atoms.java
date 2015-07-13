package org.jerlang.erts.emulator;

import org.jerlang.type.Atom;

/**
 * Common atoms.
 * 
 * Based on:
 * https://github.com/erlang/otp/erts/emulator/beam/atom.names
 */
public enum Atoms {

    am_false("false"),
    am_true("true"),
    am_Underscore("_"),
    am_Noname("nonode@nohost"),
    am_EOT("$end_of_table"),
    am_Cookie(""),

    // Used in the Beam emulator loop.
    // Smaller literals usually means tighter code.
    am_fun(),
    am_infinity(),
    am_timeout(),
    am_normal(),
    am_call(),
    am_return(),
    am_throw(),
    am_error(),
    am_exit(),
    am_undefined(),

    // Used in beam_emu.c.
    am_nocatch(),
    am_undefined_function(),
    am_undefined_lambda(),

    // All other atoms.
    // Try to keep the order alphabetic.
    am_DOWN("DOWN"),
    am_UP("UP"),
    am_EXIT("EXIT"),
    am_aborted(),
    am_abs_path(),
    am_absoluteURI(),
    am_ac(),
    am_accessor(),
    am_active(),
    am_all(),
    am_all_but_first(),
    am_all_names(),
    am_alloc_info(),
    am_alloc_sizes(),
    am_allocated(),
    am_allocated_areas(),
    am_allocator(),
    am_allocator_sizes(),
    am_alloc_util_allocators(),
    am_allow_gc(),
    am_allow_passive_connect(),
    am_already_loaded(),
    am_amd64(),
    am_anchored(),
    am_and(),
    am_andalso(),
    am_andthen(),
    am_any(),
    am_anycrlf(),
    am_apply(),
    am_args(),
    am_arg0(),
    am_arity(),
    am_asn1(),
    am_async(),
    am_asynchronous(),
    am_atom(),
    am_atom_used(),
    am_attributes(),
    am_await_port_send_result(),
    am_await_proc_exit(),
    am_await_result(),
    am_await_sched_wall_time_modifications(),
    am_awaiting_load(),
    am_awaiting_unload(),
    am_backtrace(),
    am_backtrace_depth(),
    am_badarg(),
    am_badarith(),
    am_badarity(),
    am_badfile(),
    am_badfun(),
    am_badkey(),
    am_badmap(),
    am_badmatch(),
    am_badsig(),
    am_bag(),
    am_band(),
    am_big(),
    am_bif_return_trap(),
    am_bif_timer_server(),
    am_binary(),
    am_binary_bin_to_list_trap(),
    am_binary_copy_trap(),
    am_binary_longest_prefix_trap(),
    am_binary_longest_suffix_trap(),
    am_binary_match_trap(),
    am_binary_matches_trap(),
    am_binary_to_list_continue(),
    am_binary_to_term_trap(),
    am_block(),
    am_blocked(),
    am_bm(),
    am_bnot(),
    am_bor(),
    am_bxor(),
    am_break_ignored(),
    am_breakpoint(),
    am_bsl(),
    am_bsr(),
    am_bsr_anycrlf(),
    am_bsr_unicode(),
    am_build_type(),
    am_busy_dist_port(),
    am_busy_port(),
    // am_call(),
    am_call_count(),
    am_call_time(),
    am_caller(),
    am_capture(),
    am_case_clause(),
    am_caseless(),
    am_catchlevel(),
    am_cd(),
    am_cdr(),
    am_cflags(),
    am_CHANGE("CHANGE"),
    am_characters_to_binary_int(),
    am_characters_to_list_int(),
    am_clear(),
    am_clock_service(),
    am_close(),
    am_closed(),
    am_code(),
    am_command(),
    am_compact(),
    am_compat_rel(),
    am_compile(),
    am_compressed(),
    am_config_h(),
    am_convert_time_unit(),
    am_connect(),
    am_connected(),
    am_connection_closed(),
    am_cons(),
    am_const(),
    am_context_switches(),
    am_control(),
    am_copy(),
    am_cpu(),
    am_cpu_timestamp(),
    am_cr(),
    am_crlf(),
    am_creation(),
    am_current_function(),
    am_current_location(),
    am_current_stacktrace(),
    am_data(),
    am_debug_flags(),
    am_decimals(),
    am_delay_trap(),
    am_dexit(),
    am_depth(),
    am_dgroup_leader(),
    am_dictionary(),
    am_dirty_cpu_schedulers_online(),
    am_disable_trace(),
    am_disabled(),
    am_display_items(),
    am_dist(),
    am_dist_cmd(),
    am_Div("/"),
    am_div(),
    am_dlink(),
    am_dmonitor_node(),
    am_dmonitor_p(),
    am_DollarDollar("$$"),
    am_DollarUnderscore("$_"),
    am_dollar_endonly(),
    am_dotall(),
    am_driver(),
    am_driver_options(),
    am_dsend(),
    am_dsend_continue_trap(),
    am_dunlink(),
    am_duplicate_bag(),
    am_dupnames,
    am_elib_malloc,
    am_emulator,
    am_enable_trace,
    am_enabled,
    am_endian,
    am_env,
    am_eof,
    am_eol,
    am_exception_from,
    am_exception_trace,
    am_extended,
    am_Eq("=:="),
    am_Eqeq("=="),
    am_erlang,
    am_ERROR("ERROR"),
    am_error_handler,
    am_error_logger,
    am_erts_internal,
    am_ets,
    am_ETS_TRANSFER("ETS-TRANSFER"),
    am_event,
    am_exact_reductions,
    am_exclusive,
    am_exit_status,
    am_existing,
    am_exiting,
    am_exports,
    am_external,
    // am_false,
    am_fcgi,
    am_fd,
    am_first,
    am_firstline,
    am_flags,
    am_flush,
    am_flush_monitor_messages,
    am_force,
    am_format_cpu_topology,
    am_free,
    am_fullsweep_after,
    am_fullsweep_if_old_binaries,
    // am_fun,
    am_function,
    am_functions,
    am_function_clause,
    am_garbage_collecting,
    am_garbage_collection,
    am_gc_end,
    am_gc_start,
    am_Ge(">="),
    am_generational,
    am_get_data,
    am_get_seq_token,
    am_get_tcw,
    am_getenv,
    am_gather_gc_info_result,
    am_gather_io_bytes,
    am_gather_sched_wall_time_result,
    am_getting_linked,
    am_getting_unlinked,
    am_global,
    am_Gt(">"),
    am_grun,
    am_group_leader,
    am_have_dt_utag,
    am_heap_block_size,
    am_heap_size,
    am_heap_sizes,
    am_heap_type,
    am_heart_port,
    am_heir,
    am_hidden,
    am_hide,
    am_high,
    am_hipe_architecture,
    am_http,
    am_httph,
    am_https,
    am_http_response,
    am_http_request,
    am_http_header,
    am_http_eoh,
    am_http_error,
    am_http_bin,
    am_httph_bin,
    am_id,
    am_if_clause,
    am_ignore,
    am_in,
    am_in_exiting,
    am_inactive,
    am_incomplete,
    am_inconsistent,
    am_index,
    // am_infinity,
    am_info,
    am_info_msg,
    am_initial_call,
    am_input,
    am_internal,
    am_internal_error,
    am_internal_status,
    am_instruction_counts,
    am_invalid,
    am_is_constant,
    am_is_seq_trace,
    am_io,
    am_keypos,
    am_kill,
    am_killed,
    am_kill_ports,
    am_known,
    am_label,
    am_large_heap,
    am_last_calls,
    am_latin1,
    am_ldflags,
    am_Le("=<"),
    am_lf,
    am_line,
    am_line_length,
    am_linked_in_driver,
    am_links,
    am_list,
    am_list_to_binary_continue,
    am_little,
    am_loaded,
    am_load_cancelled,
    am_load_failure,
    am_local,
    am_long_gc,
    am_long_schedule,
    am_low,
    am_Lt("<"),
    am_machine,
    am_match,
    am_match_limit,
    am_match_limit_recursion,
    am_match_spec,
    am_max,
    am_maximum,
    am_max_tables,
    am_max_processes,
    am_mbuf_size,
    am_md5,
    am_memory,
    am_memory_internal,
    am_memory_types,
    am_message,
    am_message_binary,
    am_message_queue_len,
    am_messages,
    am_merge_trap,
    am_meta,
    am_meta_match_spec,
    am_micro_seconds,
    am_milli_seconds,
    am_min_heap_size,
    am_min_bin_vheap_size,
    am_minor_version,
    am_Minus("-"),
    am_module,
    am_module_info,
    am_monitored_by,
    am_monitor,
    am_monitor_nodes,
    am_monitors,
    am_monotonic,
    am_more,
    am_multi_scheduling,
    am_multiline,
    am_nano_seconds,
    am_name,
    am_named_table,
    am_namelist,
    am_native,
    am_native_addresses,
    am_Neq("=/="),
    am_Neqeq("/="),
    am_net_kernel,
    am_net_kernel_terminated,
    am_never_utf,
    am_new,
    am_new_index,
    am_new_uniq,
    am_newline,
    am_next,
    am_no,
    am_nomatch,
    am_none,
    am_no_auto_capture,
    am_noconnect,
    am_noconnection,
    am_nocookie,
    am_node,
    am_node_type,
    am_nodedown,
    am_nodedown_reason,
    am_nodeup,
    am_noeol,
    am_nofile,
    am_noproc,
    // am_normal,
    am_nosuspend,
    am_no_float,
    am_no_integer,
    am_no_network,
    am_no_start_optimize,
    am_not,
    am_not_a_list,
    am_not_loaded,
    am_not_loaded_by_this_process,
    am_not_pending,
    am_not_purged,
    am_notalive,
    am_notbol,
    am_noteol,
    am_notempty,
    am_notempty_atstart,
    am_notify,
    am_notsup,
    am_nouse_stdio,
    am_objects,
    am_offset,
    am_ok,
    am_old_heap_block_size,
    am_old_heap_size,
    am_on_load,
    am_open,
    am_open_error,
    am_opt,
    am_or,
    am_ordered_set,
    am_orelse,
    am_os_pid,
    am_os_type,
    am_os_version,
    am_ose_bg_proc,
    am_ose_int_proc,
    am_ose_phantom,
    am_ose_pri_proc,
    am_ose_process_prio,
    am_ose_process_type,
    am_ose_ti_proc,
    am_out,
    am_out_exited,
    am_out_exiting,
    am_output,
    am_overlapped_io,
    am_owner,
    am_packet,
    am_packet_size,
    am_parallelism,
    am_Plus("+"),
    am_pause,
    am_pending,
    am_pending_driver,
    am_pending_process,
    am_pending_reload,
    am_permanent,
    am_pid,
    am_port,
    am_ports,
    am_port_count,
    am_port_limit,
    am_port_op,
    am_positive,
    am_print,
    am_priority,
    am_private,
    am_process,
    am_processes,
    am_processes_used,
    am_process_count,
    am_process_display,
    am_process_limit,
    am_process_dump,
    am_procs,
    am_proc_sig,
    am_profile,
    am_protected,
    am_protection,
    am_ptab_list_continue,
    am_public,
    am_purify,
    am_quantify,
    am_queue_size,
    am_raw,
    am_re,
    am_re_pattern,
    am_re_run_trap,
    am_read_concurrency,
    am_ready_input,
    am_ready_output,
    am_ready_async,
    am_reason,
    am_receive,
    am_recent_size,
    am_reductions,
    am_refc,
    am_register,
    am_registered_name,
    am_reload,
    am_rem,
    am_report_errors,
    am_reset,
    am_restart,
    am_return_from,
    am_return_to,
    am_return_trace,
    am_run_queue,
    am_runnable,
    am_runnable_ports,
    am_runnable_procs,
    am_running,
    am_running_ports,
    am_running_procs,
    am_runtime,
    am_safe,
    am_save_calls,
    am_scheduler,
    am_scheduler_id,
    am_schedulers_online,
    am_scheme,
    am_scientific,
    am_scope,
    am_seconds,
    am_sensitive,
    am_sequential_tracer,
    am_sequential_trace_token,
    am_serial,
    am_set,
    am_set_cpu_topology,
    am_set_data,
    am_set_on_first_link,
    am_set_on_first_spawn,
    am_set_on_link,
    am_set_on_spawn,
    am_set_seq_token,
    am_set_tcw,
    am_set_tcw_fake,
    am_separate,
    am_shared,
    am_silent,
    am_size,
    am_sl_alloc,
    am_spawn_executable,
    am_spawn_driver,
    am_ssl_tls,
    am_stack_size,
    am_start,
    am_status,
    am_static,
    am_stderr_to_stdout,
    am_stop,
    am_stream,
    am_sunrm,
    am_suspend,
    am_suspended,
    am_suspending,
    am_sys_misc,
    am_system,
    am_system_error,
    am_system_limit,
    am_system_version,
    am_system_architecture,
    am_SYSTEM("SYSTEM"),
    am_table,
    am_term_to_binary_trap,
    am_this,
    am_thread_pool_size,
    am_threads,
    am_time_offset,
    //am_timeout,
    am_timeout_value,
    am_Times("*"),
    am_timestamp,
    am_total,
    am_total_heap_size,
    am_tpkt,
    am_trace,
    am_trace_ts,
    am_traced,
    am_trace_control_word,
    am_tracer,
    am_trap_exit,
    am_try_clause,
    //am_true,
    am_tuple,
    am_type,
    am_ucompile,
    am_ucp,
    am_undef,
    am_ungreedy,
    am_unicode,
    am_unregister,
    am_urun,
    am_use_stdio,
    am_used,
    am_utf8,
    am_unblock,
    am_uniq,
    am_unless_suspending,
    am_unloaded,
    am_unloading,
    am_unloaded_only,
    am_unload_cancelled,
    am_value,
    am_values,
    am_version,
    am_visible,
    am_waiting,
    am_wall_clock,
    am_warning,
    am_warning_msg,
    am_scheduler_wall_time,
    am_wordsize,
    am_write_concurrency,
    am_xor,
    am_x86,
    am_yes,
    am_yield;

    private Atoms() {
        Atom.of(name().substring(3));
    }

    private Atoms(String value) {
        Atom.of(value);
    }

}
